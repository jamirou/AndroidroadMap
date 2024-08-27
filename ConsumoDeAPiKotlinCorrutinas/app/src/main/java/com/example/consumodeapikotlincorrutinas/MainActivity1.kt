package com.example.consumodeapikotlincorrutinas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.consumodeapikotlincorrutinas.databinding.ActivityMain1Binding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}