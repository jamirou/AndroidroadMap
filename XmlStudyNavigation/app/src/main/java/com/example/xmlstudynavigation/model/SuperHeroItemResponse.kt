package com.example.xmlstudynavigation.model

import com.google.gson.annotations.SerializedName

data class SuperHeroItemResponse(
    @SerializedName("name") val superHeroName: String,
    @SerializedName("powerstats") val powerStats: SuperHeroPowerStats,
    @SerializedName("image") val superHeroImage: SuperHeroImageDetailResponse
)

data class SuperHeroPowerStats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String,
)

data class SuperHeroImageDetailResponse(
    @SerializedName("url") val superHeroImageUrl: String
)