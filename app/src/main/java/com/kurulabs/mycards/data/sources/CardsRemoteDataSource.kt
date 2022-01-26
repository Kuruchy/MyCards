package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.CardDataApi
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class CardsRemoteDataSource @Inject constructor(
    private val cardsService: CardsApi
) : CardsDataSource {

    override suspend fun fetchAllCards(): List<CardDataApi> {
        var list = emptyList<CardDataApi>()

        cardsService.fetchUsersData().onSuccess {
            list = this.data
        }

        return list
    }
}
