package com.kurulabs.mycards.ui.detail.state

import com.kurulabs.mycards.ui.cards.models.CardActionItem
import com.kurulabs.mycards.ui.cards.models.CardData

data class CardDetailState(
    val isLoading: Boolean = false,
    val cardAction: CardActionItem.CardAction? = null,
    val cardData: CardData? = null,
)
