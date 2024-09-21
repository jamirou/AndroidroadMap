package com.example.xmlstudynavigation.superheroes

import com.example.xmlstudynavigation.model.SuperHeroItemResponse
import com.example.xmlstudynavigation.model.SuperHeroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/0e12efb2ddeab767485c2f4e1b20cc89/search/{name}")
    suspend fun getSuperHeroes(
        @Path("name") superHeroName: String
    ): Response<SuperHeroModel>

    @GET("/api/0e12efb2ddeab767485c2f4e1b20cc89/{character_id}")
    suspend fun getSuperHeroDetail(@Path("character_id") superHeroId: String): Response<SuperHeroItemResponse>

}


