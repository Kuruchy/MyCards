package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.kurulabs.mycards.data.models.UserDataApi
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface CardsApi {
    @GET("/bank/card?results=5")
    suspend fun fetchCardData(): ApiResponse<List<CardDataApi>>

    @GET("/bank/account?results=5&include_fields=entity")
    suspend fun fetchBankData(): ApiResponse<List<BankDataApi>>

    @GET("/profiles/person?results=5&include_fields=fullname")
    suspend fun fetchUserData(): ApiResponse<List<UserDataApi>>
}