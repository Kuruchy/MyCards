package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface CardsApi {
    @GET("/bank/card?results=5")
    suspend fun fetchCardData(): ApiResponse<List<CardDataApi>>

    @GET("/bank/account?results=5&exclude_fields=bic,iban_formatted,ccc_formatted,ccc,iban")
    suspend fun fetchBankData(): ApiResponse<List<BankDataApi>>
}