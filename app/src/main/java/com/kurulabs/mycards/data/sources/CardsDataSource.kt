package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.ui.models.cards.CardData

interface CardsDataSource {
    suspend fun getAllCards(): Result<List<CardData>>
}
