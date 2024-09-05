package com.example.xmlstudynavigation.view

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlstudynavigation.R

class HelloWorldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello_world)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSayHello = findViewById<AppCompatButton>(R.id.buttonSayHello)
        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)

        buttonSayHello.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                val greetingMessage = "Hello $name, have a nice day!"
                textViewGreeting.text = greetingMessage
                textViewGreeting.visibility = TextView.VISIBLE
            } else {
                editTextName.error = "Please enter your name"
            }
        }
    }
}