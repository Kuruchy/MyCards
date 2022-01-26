package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.CardDataApi
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface CardsApi {
    @GET("/bank/card")
    suspend fun fetchUsersData(): ApiResponse<List<CardDataApi>>
}