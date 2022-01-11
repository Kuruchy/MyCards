package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.model.cards.CardData
import com.kurulabs.mycards.model.cards.getColor

@Composable
internal fun BankCard(
    modifier: Modifier,
    cardData: CardData
) {
    Card(
        modifier = modifier,
        backgroundColor = cardData.getColor(),
        elevation = 4.dp
    ) {

    }
}