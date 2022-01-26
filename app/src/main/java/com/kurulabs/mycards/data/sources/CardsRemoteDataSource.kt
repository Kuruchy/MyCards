package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class CardsRemoteDataSource @Inject constructor(
    private val cardsApi: CardsApi
) : CardsDataSource {

    override suspend fun fetchAllCards(): List<CardDataApi> {
        var list = emptyList<CardDataApi>()

        cardsApi.fetchCardData().onSuccess {
            list = this.data
        }

        return list
    }

    override suspend fun fetchAllBanks(): List<BankDataApi> {
        var list = emptyList<BankDataApi>()

        cardsApi.fetchBankData().onSuccess {
            list = this.data
        }

        return list
    }
}
