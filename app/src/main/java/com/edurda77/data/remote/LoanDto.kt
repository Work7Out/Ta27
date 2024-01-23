package com.edurda77.data.remote


import com.google.gson.annotations.SerializedName

data class LoanDto(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("sum_one")
    val sumOne: String,
    @SerializedName("url")
    val url: String
)