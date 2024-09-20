package com.example.xmlstudynavigation.model

import com.google.gson.annotations.SerializedName

data class SuperHeroItemResponse(
    @SerializedName("name") val superHeroName: String,
    @SerializedName("powerstats") val powerStats: SuperHeroPowerStats,
    @SerializedName("image") val superHeroImage: SuperHeroImageDetailResponse,
    @SerializedName("biography") val superHeroBiography: SuperHeroBiography
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

data class SuperHeroBiography(
    @SerializedName("full-name") val superHeroFullName: String,
    @SerializedName("alter-egos") val superHeroAlterEgos: String,
    @SerializedName("aliases") val superHeroAliases: List<String>,
    @SerializedName("first-appearance") val superHeroFirstAppearance: String,
    @SerializedName("publisher") val superHeroPublisher: String,
    @SerializedName("alignment") val superHeroAlignment: String
)