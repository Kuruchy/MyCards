package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.ui.models.cards.CardData
import kotlinx.coroutines.flow.Flow

interface CardsRepository {
    fun observableCards(): Flow<Set<CardData>>
    suspend fun getAllCards(): Result<List<CardData>>
}
