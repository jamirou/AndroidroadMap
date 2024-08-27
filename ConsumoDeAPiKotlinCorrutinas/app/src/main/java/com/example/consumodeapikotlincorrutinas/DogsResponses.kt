package com.example.consumodeapikotlincorrutinas

import com.google.gson.annotations.SerializedName

data class DogsResponses(
    var status: String,
    @SerializedName("message") var images: List<String>
)
