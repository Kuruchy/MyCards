package com.kurulabs.mycards.ui.composable.cards

import Action
import ActionTitle
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = BottomNavigationHeight),
        ) {
            val actions = cardsState.cards.getOrNull(carouselIndex)?.actions ?: emptyList()

            item {
                Carrousel(
                    modifier = Modifier.height(maxHeight * 0.3f),
                    cards = cardsState.cards,
                    isLoading = cardsState.isLoading,
                    onSwipe = { index ->
                        carouselIndex = index
                        onSwipe.invoke(index)
                    }
                )
            }

            actions.groupBy { it.groupTitle.index }.forEach { (_, actions) ->
                item {
                    ActionTitle(
                        modifier = Modifier,
                        cardTitle = actions.first().groupTitle,
                        isLoading = cardsState.isLoading
                    )
                }
                items(actions) { action ->
                    Action(
                        cardAction = action,
                        isLoading = cardsState.isLoading
                    ) { onActionClick.invoke(action) }
                }
            }
        }
    }
}