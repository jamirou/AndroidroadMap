package com.example.middlexmlhoroscopo.motherobject

import com.example.middlexmlhoroscopo.data.network.response.PredictionResponse
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Aquarius
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Aries
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Cancer
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Capricorn
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Gemini
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Leo
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Libra
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Pisces
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Sagittarius
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Scorpio
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Taurus
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo.Virgo

object HoroscopoMotherObject {
    val anyResponse = PredictionResponse("date", "Prediction", "taurus")

    val horoscopoInfoList =
        listOf(
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