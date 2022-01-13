package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.kurulabs.mycards.model.cards.CardData


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun Carrousel(
    modifier: Modifier,
    cards: List<CardData>,
    setActions: (Int) -> Unit
) {
    BoxWithConstraints {
        val pagerState = rememberPagerState()

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

        setActions(pagerState.currentPage)
    }
}