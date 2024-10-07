
package com.example.middlexmlhoroscopo.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.middlexmlhoroscopo.R
import com.example.middlexmlhoroscopo.databinding.ActivityHoroscopoDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetailBinding
    private val horoscopoDetailViewModel: HoroscopoDetailViewModel by viewModels()
    private val arg:HoroscopoDetailActivityArgs by navArgs()

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
        initUi()
    }

    private fun initUi() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetailViewModel.state.collect {
                    when (it) {
                        HoroscopoDetailState.Loading -> loadingState()
                        is HoroscopoDetailState.Error -> errorState()
                        is HoroscopoDetailState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {

    }

    private fun errorState() {


    }

    private fun loadingState() {

    }
}