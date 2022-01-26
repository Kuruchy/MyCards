package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi

interface CardsDataSource {
    suspend fun fetchAllCards(): List<CardDataApi>
    suspend fun fetchAllBanks(): List<BankDataApi>
}
