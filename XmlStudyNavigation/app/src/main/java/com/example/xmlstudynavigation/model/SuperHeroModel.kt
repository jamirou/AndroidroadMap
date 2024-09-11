package com.example.xmlstudynavigation.model

import com.google.gson.annotations.SerializedName

data class SuperHeroModel(
    @SerializedName("response") val responseStatus: String,
    @SerializedName("results") val superHeroes: List<SuperHeroesData>
)

data class SuperHeroesData(
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val superHeroName: String,
    @SerializedName("image") val superHeroImage: SuperHeroImageUrl
)

data class SuperHeroImageUrl(
    @SerializedName("url") val superHeroImageUrl: String
)


