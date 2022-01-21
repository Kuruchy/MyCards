package com.kurulabs.mycards.ui.cards.state

import com.kurulabs.mycards.ui.cards.models.CardData

data class CardsState(
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val cards: List<CardData> = emptyList()
)
