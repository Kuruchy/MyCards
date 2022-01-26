package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.kurulabs.mycards.data.models.UserDataApi
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class CardsRemoteDataSource @Inject constructor(
    private val cardsApi: CardsApi
) : CardsDataSource {

    override suspend fun fetchAllCards(): List<CardDataApi> {
        var list = emptyList<CardDataApi>()

        cardsApi.fetchCardData().onSuccess {
            list = this.data
        }.onException {
        }.onError {
        }

        return list
    }

    override suspend fun fetchAllBanks(): List<BankDataApi> {
        var list = emptyList<BankDataApi>()

        cardsApi.fetchBankData().onSuccess {
            list = this.data
        }.onException {
        }.onError {
        }

        return list
    }

    override suspend fun fetchAllUsers(): List<UserDataApi> {
        var list = emptyList<UserDataApi>()

        cardsApi.fetchUserData().onSuccess {
            list = this.data
        }.onException {
        }.onError {
        }

        return list
    }
}
