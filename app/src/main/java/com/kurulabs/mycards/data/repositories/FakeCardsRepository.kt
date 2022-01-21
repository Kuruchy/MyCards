package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.data.sources.FakeCardsRemoteDataSource
import com.kurulabs.mycards.ui.cards.models.CardData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import javax.inject.Inject


class FakeCardsRepository @Inject constructor(
    private val cardsLocalDataSource: FakeCardsRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : CardsRepository {
    private val mutex = Mutex()
    private val cards = MutableStateFlow<Set<CardData>>(setOf())

    override fun observableCards(): Flow<Set<CardData>> = cards

    override suspend fun getAllCards(): Result<List<CardData>> = withContext(ioDispatcher) {
        cardsLocalDataSource.getAllCards()
    }
}
