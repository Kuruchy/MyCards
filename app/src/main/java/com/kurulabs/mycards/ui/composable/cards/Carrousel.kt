package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.kurulabs.mycards.model.cards.CardData


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun Carrousel(
    cards: List<CardData>,
    screenHeight: Dp,
    setActions: (Int) -> Unit
) {
    BoxWithConstraints {
        val pagerState = rememberPagerState()

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight),
            count = cards.size,
            state = pagerState,
        ) { page ->
            BankCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(maxWidth * 0.8f),
                cardData = cards[page]
            )
        }

        setActions(pagerState.currentPage)
    }
}