package com.kurulabs.mycards.ui.composable.cards

import CarrouselItem
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
import com.kurulabs.mycards.CardViewModel


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun Carrousel(
    viewModel: CardViewModel,
    screenHeight: Dp,
) {
    BoxWithConstraints {
        val pagerState = rememberPagerState()

        val cards = viewModel.cards.value
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.44f),
            count = cards.size,
            state = pagerState,
        ) { page ->
            CarrouselItem(modifier = Modifier.wrapContentHeight().width(maxWidth * 0.5f), cardData = cards[page] )
        }

        viewModel.setActions(pagerState.currentPage)
    }
}