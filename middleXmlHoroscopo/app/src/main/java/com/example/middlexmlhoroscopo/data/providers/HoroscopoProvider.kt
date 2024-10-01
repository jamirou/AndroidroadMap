package com.example.middlexmlhoroscopo.data.providers

import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProvider @Inject constructor(){
    fun getHoroscopo(): List<HoroscopoInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}