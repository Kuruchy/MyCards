package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.kurulabs.mycards.data.models.UserDataApi
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CardsApi {
    @GET("/bank/card")
    suspend fun fetchCardData(@Query("results") results: Int = 5): ApiResponse<List<CardDataApi>>

    @GET("/bank/account")
    suspend fun fetchBankData(
        @Query("results") results: Int = 5,
        @Query("include_fields") includeFields: String = "entity"
    ): ApiResponse<List<BankDataApi>>
}