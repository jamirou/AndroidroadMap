package com.example.getapijetpackcomposeretrofithilt.api

import com.example.getapijetpackcomposeretrofithilt.model.ListCharacters
import retrofit2.http.GET

interface CharactersAPI {
    @GET("character")
    suspend fun getCharacters(): ListCharacters
}