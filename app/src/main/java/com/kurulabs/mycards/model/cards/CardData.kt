package com.kurulabs.mycards.model.cards

import com.kurulabs.mycards.model.cards.CardActionItem.CardAction
import com.kurulabs.mycards.ui.theme.Orange
import com.kurulabs.mycards.ui.theme.Turquoise

data class CardData(
    val typeName: CardType,
    val maskedNumber: String,
    val owner: String,
    val actions: List<CardAction>
)

fun CardData.getColor() = when (typeName) {
    CardType.DEBIT -> Turquoise
    CardType.CREDIT -> Orange
}