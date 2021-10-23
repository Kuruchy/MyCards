package com.kurulabs.mycards.ui.composable

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kurulabs.mycards.CardViewModel
import com.kurulabs.mycards.ui.theme.MyCardsTheme


@Composable
fun CardOverview(viewModel: CardViewModel, context: Context) {
    MyCardsTheme {
        val cards = viewModel.cards
        val rowState = rememberLazyListState()

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
        ) {
            Carrousel(rowState, cards)
            Actions(cards, rowState, context)
        }
    }
}