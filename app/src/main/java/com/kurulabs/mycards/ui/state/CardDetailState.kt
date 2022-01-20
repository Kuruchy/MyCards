package com.kurulabs.mycards.ui.state

import com.kurulabs.mycards.ui.models.cards.CardActionItem
import com.kurulabs.mycards.ui.models.cards.CardData

data class CardDetailState(
    val isLoading: Boolean = false,
    val cardAction: CardActionItem.CardAction? = null,
    val cardData: CardData? = null,
)
