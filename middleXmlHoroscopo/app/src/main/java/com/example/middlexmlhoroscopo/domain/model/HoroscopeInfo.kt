package com.example.middlexmlhoroscopo.domain.model

import com.example.middlexmlhoroscopo.R

sealed class HoroscopeInfo(
    val img: Int,
    val name: Int,
) {
    object Aries : HoroscopeInfo(img = R.drawable.aries, name = R.string.aries)
    object Taurus : HoroscopeInfo(img = R.drawable.tauro, name = R.string.taurus)
    object Gemini : HoroscopeInfo(img = R.drawable.geminis, name = R.string.gemini)
    object Cancer : HoroscopeInfo(img = R.drawable.cancer, name = R.string.cancer)
    object Leo : HoroscopeInfo(img = R.drawable.leo, name = R.string.leo)
    object Virgo : HoroscopeInfo(img = R.drawable.virgo, name = R.string.virgo)
    object Libra : HoroscopeInfo(img = R.drawable.libra, name = R.string.libra)
    object Scorpio : HoroscopeInfo(img = R.drawable.escorpio, name = R.string.scorpio)
    object Sagittarius : HoroscopeInfo(img = R.drawable.sagitario, name = R.string.sagittarius)
    object Capricorn : HoroscopeInfo(img = R.drawable.capricornio, name = R.string.capricorn)
    object Aquarius : HoroscopeInfo(img = R.drawable.aquario, name = R.string.aquarius)
    object Pisces : HoroscopeInfo(img = R.drawable.piscis, name = R.string.pisces)
}
