package com.kurulabs.mycards.ui.composable

import Card
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.model.CardData


@Composable
internal  fun Carrousel(
    rowState: LazyListState,
    cards: MutableState<List<CardData>>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .background(color = MaterialTheme.colors.background),
        state = rowState,
    ) {
        items(
            items = cards.value,
            itemContent = { item ->
                Card(modifier = Modifier.width(400.dp), cardData = item)
            }
        )
    }
}