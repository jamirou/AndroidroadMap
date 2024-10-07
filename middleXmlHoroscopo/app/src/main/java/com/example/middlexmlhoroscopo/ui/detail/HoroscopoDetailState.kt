package com.example.middlexmlhoroscopo.ui.detail

sealed class HoroscopoDetailState {
    data object Loading: HoroscopoDetailState()
    data class Error(val error: String): HoroscopoDetailState()
    data class Success(val prediction: String, val sign: String): HoroscopoDetailState()
}
