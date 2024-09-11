package com.example.xmlstudynavigation.superheroes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.databinding.ActivitySuperHeroListBinding
import com.example.xmlstudynavigation.model.SuperHeroModel
import com.example.xmlstudynavigation.superheroes.SuperHeroDetailsActivity.Companion.HERO_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        binding.SearchViewSearchHero.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = SuperHeroAdapter { navigateToSuperHeroDetail(it) }
        binding.RecyclerViewSuperHeroList.layoutManager = LinearLayoutManager(this)
        binding.RecyclerViewSuperHeroList.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String) {
        binding.ProgressBarLoading.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val responseStatus: Response<SuperHeroModel> =
                retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if (responseStatus.isSuccessful) {
                Log.i("ResponseStatus", "${responseStatus.body()}")
                val response: SuperHeroModel? = responseStatus.body()
                if (response != null) {
                    Log.i("ResponseStatus", response.toString())
                    runOnUiThread {
                        adapter.updateSuperHeroList(response.superHeroes)
                        binding.ProgressBarLoading.isVisible = false
                    }
                }
            } else {
                Log.i("ResponseStatus", "Error")
            }
        }
    }

    private fun navigateToSuperHeroDetail(id: String) {
        val intent = Intent(this, SuperHeroDetailsActivity::class.java)
        intent.putExtra(HERO_ID, id)
        startActivity(intent)
    }

}
