package com.example.middlexmlhoroscopo.data.network

import com.example.middlexmlhoroscopo.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {
    @GET ("/{sign}")
    suspend fun getHoroscopo(@Path("sign") sign:String): PredictionResponse
}