package com.example.consumodeapikotlincorrutinas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.consumodeapikotlincorrutinas.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}