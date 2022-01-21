package com.kurulabs.mycards.ui.cards

import Action
import ActionTitle
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.data.sources.getDemoCards
import com.kurulabs.mycards.ui.main.elements.BottomNavigationHeight
import com.kurulabs.mycards.ui.cards.models.CardActionItem
import com.kurulabs.mycards.ui.cards.state.CardsState
import com.kurulabs.mycards.ui.theme.MyCardsTheme

@Preview(showBackground = true)
@Composable
fun CardOverviewPreview() {
    MyCardsTheme {
        CardOverview(
            cardsState = CardsState(cards = getDemoCards()),
            carrouselIndex = 0,
            onSwipe = {},
            onActionClick = {}
        )
    }
}

@Composable
fun CardOverview(
    cardsState: CardsState,
    carrouselIndex: Int,
    onSwipe: (Int) -> Unit,
    onActionClick: (CardActionItem.CardAction) -> Unit
) {
    BoxWithConstraints {
        val maxHeight = maxHeight
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = BottomNavigationHeight),
        ) {
            val actions = cardsState.cards.getOrNull(carrouselIndex)?.actions ?: emptyList()

            item {
                Carrousel(
                    modifier = Modifier
                        .defaultMinSize(minHeight = 160.dp)
                        .height(maxHeight * 0.3f),
                    cards = cardsState.cards,
                    isLoading = cardsState.isLoading,
                    onSwipe = { index ->
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