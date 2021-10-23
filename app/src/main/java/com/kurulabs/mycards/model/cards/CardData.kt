package com.kurulabs.mycards.model.cards

import com.kurulabs.mycards.model.cards.CardActionItem.CardAction

data class CardData(
    val typeName: String,
    val maskedNumber: String,
    val owner: String,
    val icon: CardIcon,
    val actions: List<CardAction>
)
