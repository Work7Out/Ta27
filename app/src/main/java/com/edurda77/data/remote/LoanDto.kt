package com.edurda77.data.remote


import com.google.gson.annotations.SerializedName

data class LoanDto(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("percent")
    val percent: String,
    @SerializedName("sum_one")
    val sumOne: String,
    @SerializedName("term_to")
    val termTo: String,
    @SerializedName("url")
    val url: String
)