package com.example.middlexmlhoroscopo.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetailViewModel @Inject constructor(): ViewModel() {
    private var _state = MutableStateFlow<HoroscopoDetailState>(HoroscopoDetailState.Loading)
    val state: StateFlow<HoroscopoDetailState> = _state
}