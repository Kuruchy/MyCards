package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.kurulabs.mycards.ui.models.cards.CardData


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun Carrousel(
    modifier: Modifier,
    cards: List<CardData>,
    onSwipe: (Int) -> Unit
) {
    BoxWithConstraints {
        val pagerState = rememberPagerState()

        Column {
            HorizontalPager(
                modifier = modifier
                    .fillMaxWidth(),
                count = cards.size,
                state = pagerState,
            ) { page ->
                BankCard(
                    modifier = Modifier
                        .aspectRatio(1.5f)
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                    cardData = cards[page]
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            )
        }

        onSwipe(pagerState.currentPage)
    }
}