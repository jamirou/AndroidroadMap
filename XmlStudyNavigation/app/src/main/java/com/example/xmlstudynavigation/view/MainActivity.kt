package com.example.xmlstudynavigation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.superheroes.SuperHeroListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonHelloWorld = findViewById<AppCompatButton>(R.id.ButtonHelloWorld)
        buttonHelloWorld.setOnClickListener { navigateToHelloWorld() }
        val buttonIMC = findViewById<AppCompatButton>(R.id.ButtonImcCalculator)
        buttonIMC.setOnClickListener { navigateToIMC() }
        val buttonToDo = findViewById<AppCompatButton>(R.id.ButtonToDoApp)
        buttonToDo.setOnClickListener { navigateToToDo() }
        val buttonSuperHero = findViewById<AppCompatButton>(R.id.ButtonSuperHero)
        buttonSuperHero.setOnClickListener { navigateToSuperHero() }
    }

    private fun navigateToSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMC() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloWorld() {
        val intent = Intent(this, HelloWorldActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToToDo() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}