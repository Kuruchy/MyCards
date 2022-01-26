package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.data.sources.CardsRemoteDataSource
import com.kurulabs.mycards.ui.cards.models.CardData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CardsRemoteRepository @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val cardsMapper: CardsMapper,
    private val cardsRemoteDataSource: CardsRemoteDataSource,
) : CardsRepository {
    private val mutex = Mutex()
    private val cards = MutableStateFlow<Set<CardData>>(setOf())

    override fun observableCards(): Flow<Set<CardData>> = cards

    override suspend fun getAllCards(): List<CardData> = withContext(ioDispatcher) {
        cardsMapper.map(cardsRemoteDataSource.fetchAllCards())
    }
}
