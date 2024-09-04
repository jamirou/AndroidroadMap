package com.example.xmlstudynavigation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlstudynavigation.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvImcResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvImcDescription: TextView
    private lateinit var btnRecalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result: Double = intent.extras?.getString(IMC_KEY)?.toDoubleOrNull() ?: 0.0
        initComponents()
        initUI(result)

    }

    private fun initUI(result: Double) {
        when (result) {
            //low weight
            in 0.00..18.50 -> {
                tvImcResult.text = getString(R.string.low_weight)
                tvImc.text = result.toString()
                tvImcDescription.text = getString(R.string.low_weight_description)
            }
            //normal weight
            in 18.51..24.99 -> {
                tvImcResult.text = getString(R.string.normal_weight)
                tvImc.text = result.toString()
                tvImcDescription.text = getString(R.string.normal_weight_description)
            }
            //overweight
            in 25.00..29.99 -> {
                tvImcResult.text = getString(R.string.over_weight)
                tvImc.text = result.toString()
                tvImcDescription.text = getString(R.string.over_weight_description)
            }
            //obesity
            in 30.00..99.00 -> {
                tvImcResult.text = getString(R.string.obesity)
                tvImc.text = result.toString()
                tvImcDescription.text = getString(R.string.obesity_description)
            }

            else -> {
                tvImcResult.text = getString(R.string.error_weight)
                tvImc.text = result.toString()
                tvImcDescription.text = getString(R.string.error_weight_description)
            }
        }
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initComponents() {
        tvImc = findViewById(R.id.TvIMC)
        tvImcResult = findViewById(R.id.TvIMCResult)
        tvImcDescription = findViewById(R.id.TvIMCDescription)
        btnRecalculate = findViewById(R.id.ButtonCalculateAgain)
    }
}