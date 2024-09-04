package com.example.xmlstudynavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcCalculatorActivity : AppCompatActivity() {

    private var selectedGender: Gender = Gender.MALE
    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
    }

    private fun initListeners() {
        cardMale.setOnClickListener {
            changeGender(Gender.MALE)
        }
        cardFemale.setOnClickListener {
            changeGender(Gender.FEMALE)
        }
    }

    private fun initComponents() {
        cardMale = findViewById(R.id.CardMale)
        cardFemale = findViewById(R.id.CardFemale)
    }

    private fun changeGender(gender: Gender) {
        selectedGender = gender
        setGenderColor()
    }

    private fun setGenderColor() {
        cardMale.setCardBackgroundColor(setBackgroundColor(selectedGender == Gender.MALE))
        cardFemale.setCardBackgroundColor(setBackgroundColor(selectedGender == Gender.FEMALE))
    }

    private fun setBackgroundColor(isSelectedComponent: Boolean): Int {
        val currentCardColor = if (isSelectedComponent) {
            R.color.pressed_color
        } else {
            R.color.normal_color
        }
        return ContextCompat.getColor(this, currentCardColor)
    }

}