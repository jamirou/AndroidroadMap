package com.example.firebasepractice.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasepractice.domain.CanAccessToApp
import com.example.firebasepractice.presentation.model.Artist
import com.example.firebasepractice.presentation.model.Player
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    private var canAccessToApp: CanAccessToApp = CanAccessToApp()
    private val realtimeDatabase = Firebase.database
    private var db: FirebaseFirestore = com.google.firebase.ktx.Firebase.firestore
    private val _artists = MutableStateFlow<List<Artist>>(emptyList())
    val artists: StateFlow<List<Artist>> = _artists

    private val _player = MutableStateFlow<Player?>(null)
    val player: StateFlow<Player?> = _player

    private val _blockVersion = MutableStateFlow<Boolean>(false)
    val blockVersion:StateFlow<Boolean> = _blockVersion

    init {
        /*repeat(20) {
        loadData()
        }*/
        checkUserVersion()
        getArtists()
        getPlayer()
    }

    private fun checkUserVersion() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                canAccessToApp()
            }
            _blockVersion.value = !result
        }
    }

    private fun getPlayer() {
        viewModelScope.launch {
            collectPlayer().collect {
                val player = it.getValue(Player::class.java)
                _player.value = player
            }
        }
    }

    private fun loadData() {
        val random = (1..10000).random()
        val artist = Artist(
            name = "Artist $random",
            description = "Description $random",
            image = "https://picsum.photos/200"
        )
        db.collection("artists")
            .add(artist)

    }

    private fun getArtists() {
        viewModelScope.launch {
            val result: List<Artist> = withContext(Dispatchers.IO) {
                getAllArtists()
            }
            _artists.value = result
        }
    }

    private suspend fun getAllArtists(): List<Artist> {
        return try {
            db.collection("artists")
                .get()
                .await()
                .documents
                .mapNotNull { snapshot ->
                    snapshot.toObject(Artist::class.java)
                }
        } catch (e: Exception) {
            emptyList()
        }
    }


    private fun collectPlayer(): Flow<DataSnapshot> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                trySend(snapshot).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Jamiron", "Error: ${error.message}")
                close(error.toException())
            }

        }

        val ref = realtimeDatabase.reference.child("player")
        ref.addValueEventListener(listener)

        awaitClose {
            ref.removeEventListener(listener)
        }

    }

    fun onPlaySelected() {
        if (player.value != null) {
            val currentPlayer = _player.value?.copy(play = !player.value?.play!!)
            val ref = realtimeDatabase.reference.child("player")
            ref.setValue(currentPlayer)
        }
    }

    fun onCancelSelected() {
        val ref = realtimeDatabase.reference.child("player")
        ref.setValue(null)
    }

    fun addPlayer(artist: Artist) {
        val ref = realtimeDatabase.reference.child("player")
        val player = Player(artist = artist, play = true)
        ref.setValue(player)
    }

}