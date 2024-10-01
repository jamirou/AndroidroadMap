package com.example.middlexmlhoroscopo.domain.model

import com.example.middlexmlhoroscopo.R

sealed class HoroscopoInfo(
    val img: Int,
    val name: Int,
) {
    object Aries : HoroscopoInfo(img = R.drawable.aries, name = R.string.aries)
    object Taurus : HoroscopoInfo(img = R.drawable.tauro, name = R.string.taurus)
    object Gemini : HoroscopoInfo(img = R.drawable.geminis, name = R.string.gemini)
    object Cancer : HoroscopoInfo(img = R.drawable.cancer, name = R.string.cancer)
    object Leo : HoroscopoInfo(img = R.drawable.leo, name = R.string.leo)
    object Virgo : HoroscopoInfo(img = R.drawable.virgo, name = R.string.virgo)
    object Libra : HoroscopoInfo(img = R.drawable.libra, name = R.string.libra)
    object Scorpio : HoroscopoInfo(img = R.drawable.escorpio, name = R.string.scorpio)
    object Sagittarius : HoroscopoInfo(img = R.drawable.sagitario, name = R.string.sagittarius)
    object Capricorn : HoroscopoInfo(img = R.drawable.capricornio, name = R.string.capricorn)
    object Aquarius : HoroscopoInfo(img = R.drawable.aquario, name = R.string.aquarius)
    object Pisces : HoroscopoInfo(img = R.drawable.piscis, name = R.string.pisces)
}
