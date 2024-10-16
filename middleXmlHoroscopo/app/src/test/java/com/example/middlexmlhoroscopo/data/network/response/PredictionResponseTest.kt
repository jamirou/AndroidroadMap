package com.example.middlexmlhoroscopo.data.network.response

import com.example.middlexmlhoroscopo.motherobject.HoroscopoMotherObject
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {
    @Test
    fun `toDomain should return a correct PredictionModel`() {
        /*Given*/
        val horoscopoResponse = HoroscopoMotherObject.anyResponse
        /*When*/
        val predictionModel = horoscopoResponse.toDomain()
        /*Then*/
        predictionModel.sign shouldBe  horoscopoResponse.sign
        predictionModel.horoscopo shouldBe horoscopoResponse.horoscopo

    }
}