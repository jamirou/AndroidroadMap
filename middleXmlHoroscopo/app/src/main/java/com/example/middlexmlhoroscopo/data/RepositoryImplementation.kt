package com.example.middlexmlhoroscopo.data

import android.util.Log
import com.example.middlexmlhoroscopo.data.network.HoroscopoApiService
import com.example.middlexmlhoroscopo.domain.Repository
import com.example.middlexmlhoroscopo.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopoApiService) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscopo(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("RepositoryImplementation", "The error is ${it.message}") }
        return null
    }
}