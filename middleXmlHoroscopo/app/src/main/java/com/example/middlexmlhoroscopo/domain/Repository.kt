package com.example.middlexmlhoroscopo.domain

import com.example.middlexmlhoroscopo.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}