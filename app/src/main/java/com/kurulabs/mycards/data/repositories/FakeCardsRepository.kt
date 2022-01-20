package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.data.sources.CardsLocalDataSource
import com.kurulabs.mycards.ui.models.cards.CardData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import javax.inject.Inject


class FakeCardsRepository @Inject constructor(
    private val cardsLocalDataSource: CardsLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : CardsRepository {
    private val mutex = Mutex()
    private val cards = MutableStateFlow<Set<CardData>>(setOf())

    override fun observableCards(): Flow<Set<CardData>> = cards

    override suspend fun getAllCards(): Result<List<CardData>> = withContext(ioDispatcher) {
        delay(800)
        if (shouldRandomlyFail()) {
            Result.failure(IllegalStateException())
        } else {
            Result.success(cardsLocalDataSource.getAllCards())
        }
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}
