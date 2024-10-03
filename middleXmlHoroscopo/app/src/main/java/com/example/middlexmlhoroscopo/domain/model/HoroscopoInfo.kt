package com.example.middlexmlhoroscopo.domain.model

import com.example.middlexmlhoroscopo.R

sealed class HoroscopoInfo(
    val img: Int,
    val name: Int,
) {
    data object Aries : HoroscopoInfo(img = R.drawable.aries, name = R.string.aries)
    data object Taurus : HoroscopoInfo(img = R.drawable.tauro, name = R.string.taurus)
    data object Gemini : HoroscopoInfo(img = R.drawable.geminis, name = R.string.gemini)
    data object Cancer : HoroscopoInfo(img = R.drawable.cancer, name = R.string.cancer)
    data object Leo : HoroscopoInfo(img = R.drawable.leo, name = R.string.leo)
    data object Virgo : HoroscopoInfo(img = R.drawable.virgo, name = R.string.virgo)
    data object Libra : HoroscopoInfo(img = R.drawable.libra, name = R.string.libra)
    data object Scorpio : HoroscopoInfo(img = R.drawable.escorpio, name = R.string.scorpio)
    data object Sagittarius : HoroscopoInfo(img = R.drawable.sagitario, name = R.string.sagittarius)
    data object Capricorn : HoroscopoInfo(img = R.drawable.capricornio, name = R.string.capricorn)
    data object Aquarius : HoroscopoInfo(img = R.drawable.aquario, name = R.string.aquarius)
    data object Pisces : HoroscopoInfo(img = R.drawable.piscis, name = R.string.pisces)
}
