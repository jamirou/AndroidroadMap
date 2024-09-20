package com.example.xmlstudynavigation.superheroes

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.databinding.ActivitySuperHeroDetailsBinding
import com.example.xmlstudynavigation.model.SuperHeroItemResponse
import com.example.xmlstudynavigation.model.SuperHeroPowerStats
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class SuperHeroDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroDetailsBinding

    companion object {
        const val HERO_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val superHeroId: String = intent.getStringExtra(HERO_ID).orEmpty()
        getSuperHeroInformation(superHeroId)
    }

    private fun getSuperHeroInformation(superHeroId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superHeroDetail =
                getRetrofit().create(ApiService::class.java).getSuperHeroDetail(superHeroId)

            if (superHeroDetail.body() != null) {
                //Coroutine
                runOnUiThread {
                    createUI(superHeroDetail.body()!!)
                }
            }
        }
    }

    private fun createUI(superHero: SuperHeroItemResponse) {
        Picasso.get().load(superHero.superHeroImage.superHeroImageUrl)
            .into(binding.ImageViewSuperHeroImage)
        binding.TextViewSuperHeroName.text = superHero.superHeroName
        prepareStats(superHero.powerStats)
        binding.TextViewSuperHeroFullName.text = superHero.superHeroBiography.superHeroFullName
        binding.TextViewSuperHeroPublisher.text = superHero.superHeroBiography.superHeroPublisher
        binding.TextViewSuperHeroAlterEgo.text = superHero.superHeroBiography.superHeroAlterEgos
        binding.TextViewSuperHeroFirstAppearance.text =
            superHero.superHeroBiography.superHeroFirstAppearance
        binding.TextViewSuperHeroAlignment.text = superHero.superHeroBiography.superHeroAlignment

        val aliases = superHero.superHeroBiography.superHeroAliases.joinToString(", ")
        binding.TextViewSuperHeroAliases.text = aliases

    }

    private fun prepareStats(powerStats: SuperHeroPowerStats) {
        updateHeight(binding.ViewIntelligence, powerStats.intelligence)
        updateHeight(binding.ViewStrength, powerStats.strength)
        updateHeight(binding.ViewSpeed, powerStats.speed)
        updateHeight(binding.ViewDurability, powerStats.durability)
        updateHeight(binding.ViewPower, powerStats.power)
        updateHeight(binding.ViewCombat, powerStats.combat)
    }

    private fun updateHeight(view: View, targetHeight: String) {
        val params = view.layoutParams
        params.height = pixelToDP(targetHeight.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDP(pixels: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            pixels,
            resources.displayMetrics
        ).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}