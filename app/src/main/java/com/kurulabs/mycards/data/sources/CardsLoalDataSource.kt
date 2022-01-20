package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.ui.models.cards.CardData
import javax.inject.Inject

class CardsLocalDataSource @Inject constructor() {
    suspend fun getAllCards(): List<CardData> {
        return getDemoCards()
    }
}
