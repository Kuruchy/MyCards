package com.kurulabs.mycards.ui.models.cards

import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction
import com.kurulabs.mycards.ui.theme.Orange
import com.kurulabs.mycards.ui.theme.Turquoise

data class CardData(
    val bankName: String,
    val typeName: CardType,
    val number: String,
    val validDate: String,
    val owner: String,
    val actions: List<CardAction>
)

fun CardData.getBackgroundColor() = when (typeName) {
    CardType.DEBIT -> Turquoise
    CardType.CREDIT -> Orange
}

fun CardData.getTextColor() = when (typeName) {
    CardType.DEBIT -> Orange
    CardType.CREDIT -> Turquoise
}