package com.example.middlexmlhoroscopo.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.example.middlexmlhoroscopo.data.providers.HoroscopoProvider
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopoProvider: HoroscopoProvider) : ViewModel() {
    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo

    init {
        _horoscopo.value = horoscopoProvider.getHoroscopo()
    }
}