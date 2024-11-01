package com.example.firebasepractice.presentation.home

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun HomeScreen(db: FirebaseFirestore) {


    Button(onClick = {
        createArtist(db)
    }) {
        Text("Add artist")
    }
}

data class Artist(
    val name: String,
    val numberOfSongs: Int
)

fun createArtist(db: FirebaseFirestore) {
    val random = (1..10000).random()
    val artist = Artist(name = "Random $random", numberOfSongs = random)
    db.collection("artists").add(artist)
        .addOnSuccessListener { Log.i("Jamiron", "Artist added") }
        .addOnFailureListener { Log.i("Jamiron", "Something went wrong") }
        .addOnCompleteListener { Log.i("Jamiron", "Completed") }

}