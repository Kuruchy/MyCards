package com.kurulabs.mycards.ui.state

import com.kurulabs.mycards.ui.models.cards.CardData

data class CardsState(
    val isLoading: Boolean = false,
    val cards: List<CardData> = emptyList()
)
