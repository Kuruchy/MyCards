package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kurulabs.mycards.data.sources.getDemoCards
import com.kurulabs.mycards.ui.composable.main.BottomNavigationHeight
import com.kurulabs.mycards.ui.models.cards.CardActionItem
import com.kurulabs.mycards.ui.state.CardsState
import com.kurulabs.mycards.ui.theme.MyCardsTheme

@Preview(showBackground = true)
@Composable
fun CardOverviewPreview() {
    MyCardsTheme {
        CardOverview(
            cardsState = CardsState(cards = getDemoCards()),
            onSwipe = {},
            onActionClick = {}
        )
    }
}

@Composable
fun CardOverview(
    cardsState: CardsState,
    onSwipe: (Int) -> Unit,
    onActionClick: (CardActionItem.CardAction) -> Unit
) {
    var carouselIndex by remember { mutableStateOf(0) }

    BoxWithConstraints {
        val maxHeight = maxHeight
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = BottomNavigationHeight),
            verticalArrangement = Arrangement.Top,
        ) {
            Carrousel(
                modifier = Modifier.height(maxHeight * 0.3f),
                cards = cardsState.cards,
                onSwipe = { index ->
                    carouselIndex = index
                    onSwipe.invoke(index)
                }
            )
            Actions(
                modifier = Modifier.height(maxHeight * 0.7f),
                actions = cardsState.cards.getOrNull(carouselIndex)?.actions ?: emptyList(),
                onClick = onActionClick
            )
        }
    }
}