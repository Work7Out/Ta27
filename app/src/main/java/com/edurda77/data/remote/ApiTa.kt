package com.edurda77.data.remote

import retrofit2.http.GET

interface ApiTa {
    @GET("api.json")
    suspend fun getData() : List<LoanDto>
}