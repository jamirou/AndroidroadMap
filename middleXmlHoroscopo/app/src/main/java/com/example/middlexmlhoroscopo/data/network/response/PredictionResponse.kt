package com.example.middlexmlhoroscopo.data.network.response

import com.example.middlexmlhoroscopo.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscopo: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscopo = horoscopo,
            sign = sign
        )
    }
}
