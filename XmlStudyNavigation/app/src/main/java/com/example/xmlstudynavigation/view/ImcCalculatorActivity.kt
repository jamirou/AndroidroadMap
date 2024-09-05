package com.example.xmlstudynavigation.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlstudynavigation.Gender
import com.example.xmlstudynavigation.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {

    private var selectedGender: Gender = Gender.MALE
    private var currentWeight: Int = 70
    private var currentAge: Int = 20
    private var currentHeight: Int = 120

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvWeight: TextView

    private lateinit var tvAge: TextView
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton

    private lateinit var btnCalculator: AppCompatButton

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

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
        setWeight()
        setAge()
    }

    private fun initListeners() {
        cardMale.setOnClickListener {
            changeGender(Gender.MALE)
        }
        cardFemale.setOnClickListener {
            changeGender(Gender.FEMALE)
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            tvHeight.text = getString(R.string.height_format, value.toInt())
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculator.setOnClickListener {
            val imcResult = calculateImc()
            navigateToResult(imcResult)
        }
    }

    private fun navigateToResult(imcResult: String) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, imcResult)
        startActivity(intent)
    }

    private fun calculateImc():String {
        val heightInMeters = currentHeight / 100.0
        val imc = currentWeight / (heightInMeters * heightInMeters)
        return String.format("%.2f", imc)
//        Log.i("IMC", "El IMC es $imcFormatted")
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }


    private fun initComponents() {
        cardMale = findViewById(R.id.CardMale)
        cardFemale = findViewById(R.id.CardFemale)
        tvHeight = findViewById(R.id.TvHeight)
        rsHeight = findViewById(R.id.RsHeight)

        btnSubtractWeight = findViewById(R.id.BtnSubtractWeight)
        btnAddWeight = findViewById(R.id.BtnAddWeight)
        tvWeight = findViewById(R.id.TvWeight)

        tvAge = findViewById(R.id.TvAge)
        btnAddAge = findViewById(R.id.BtnAddAge)
        btnSubtractAge = findViewById(R.id.BtnSubtractAge)

        btnCalculator = findViewById(R.id.BtnCalculate)
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