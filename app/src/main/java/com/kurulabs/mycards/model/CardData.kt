package com.kurulabs.mycards.model

import com.kurulabs.mycards.model.CardActionItem.CardAction

data class CardData(
    val typeName: String,
    val maskedNumber: String,
    val owner: String,
    val icon: CardIcon,
    val actions: List<CardAction>
)
