package com.example.middlexmlhoroscopo.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.middlexmlhoroscopo.R
import com.example.middlexmlhoroscopo.databinding.ActivityHoroscopoDetailBinding
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Aquarius
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Aries
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Cancer
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Capricorn
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Geminis
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Leo
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Libra
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Pisces
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Sagittarius
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Scorpio
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Taurus
import com.example.middlexmlhoroscopo.domain.model.HoroscopoModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetailBinding
    private val horoscopoDetailViewModel: HoroscopoDetailViewModel by viewModels()
    private val arg: HoroscopoDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopoDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        horoscopoDetailViewModel.getHoroscopo(arg.type)
        initUi()
    }

    private fun initUi() {
        initListeners()
        initUiState()
    }

    private fun initListeners() {
        binding.ImageViewBack.setOnClickListener { onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetailViewModel.state.collect {
                    when (it) {
                        HoroscopoDetailState.Loading -> loadingState()
                        is HoroscopoDetailState.Error -> errorState()
                        is HoroscopoDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.ProgressbarDetail.isVisible = true

    }

    private fun errorState() {
        binding.ProgressbarDetail.isVisible = false
    }

    private fun successState(state: HoroscopoDetailState.Success) {
        binding.ProgressbarDetail.isVisible = true
        binding.TextViewDetail.text = state.sign
        binding.TextViewDetailBody.text = state.prediction

        val images = when (state.horoscopoModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Geminis -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ImageViewDetail.setImageResource(images)
    }
}