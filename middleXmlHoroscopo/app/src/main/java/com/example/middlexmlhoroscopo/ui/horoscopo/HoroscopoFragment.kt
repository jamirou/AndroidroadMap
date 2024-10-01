package com.example.middlexmlhoroscopo.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middlexmlhoroscopo.databinding.FragmentHoroscopoBinding
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo
import com.example.middlexmlhoroscopo.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private lateinit var horoscopoAdapter: HoroscopoAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        initList()
        initUiState()
    }

    private fun initList() {
        horoscopoAdapter = HoroscopoAdapter()

        binding.RecyclerViewHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoAdapter
        }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopo.collect {
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}