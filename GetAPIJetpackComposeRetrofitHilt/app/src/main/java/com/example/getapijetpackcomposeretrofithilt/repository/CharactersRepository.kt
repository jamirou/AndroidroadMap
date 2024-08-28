package com.example.getapijetpackcomposeretrofithilt.repository

import com.example.getapijetpackcomposeretrofithilt.api.CharactersAPI
import com.example.getapijetpackcomposeretrofithilt.model.ListCharacters
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersAPI: CharactersAPI
) {
    suspend fun getCharacters() : ListCharacters {
        return charactersAPI.getCharacters()
    }
}