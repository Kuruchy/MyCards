package com.kurulabs.mycards.ui.composable

import Card
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.CardViewModel


@Composable
internal fun Carrousel(
    viewModel: CardViewModel,
) {
    val rowState = rememberLazyListState()

    viewModel.setActions(rowState.firstVisibleItemIndex)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .padding(horizontal = 8.dp)
            .background(color = MaterialTheme.colors.background),
        state = rowState,
    ) {
        val cards = viewModel.cards.value
        cards.groupBy { it.typeName }.forEach { (_, cards) ->
            items(cards) { card ->
                Card(modifier = Modifier.width(400.dp), cardData = card)
            }
        }
    }
}