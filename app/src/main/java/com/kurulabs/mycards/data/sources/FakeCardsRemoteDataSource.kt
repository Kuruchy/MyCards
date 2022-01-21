package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.ui.models.cards.CardData
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeCardsRemoteDataSource @Inject constructor() : CardsDataSource {
    override suspend fun getAllCards(): Result<List<CardData>> {
        delay(requestDelay)
        return if (shouldRandomlyFail()) {
            Result.failure(IllegalStateException())
        } else {
            Result.success(getDemoCards())
        }
    }

    private var requestDelay = (800L..2000L).random()
    private var requestCount = 0
    private fun shouldRandomlyFail() = ++requestCount % 5 == 0
}
