package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.ui.cards.models.CardData

interface CardsDataSource {
    suspend fun getAllCards(): Result<List<CardData>>
}
