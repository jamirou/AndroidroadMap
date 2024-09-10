package com.example.xmlstudynavigation.model

import com.google.gson.annotations.SerializedName

data class SuperHeroModel(
    @SerializedName("response") val responseStatus: String,
    @SerializedName("results") val superHeroes: List<SuperHeroesData>
)

data class SuperHeroesData(
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val superHeroName: String,
//    @SerializedName("powerstats") val superHeroPowerStats: List<SuperHeroesStats>
)

data class SuperHeroesStats(
    @SerializedName("intelligence") val superHeroIntelligence: String,
    @SerializedName("strength") val superHeroStrength: String,
    @SerializedName("speed") val superHeroSpeed: String,
    @SerializedName("durability") val superHeroDurability: String,
    @SerializedName("power") val superHeroPower: String,
    @SerializedName("combat") val superHeroCombat: String
)

