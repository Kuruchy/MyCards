package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kurulabs.mycards.ui.composable.main.BottomNavigationHeight
import com.kurulabs.mycards.ui.models.cards.CardActionItem
import com.kurulabs.mycards.ui.state.CardViewModel

@Composable
fun CardOverview(
    viewModel: CardViewModel,
    onActionClick: (CardActionItem.CardAction) -> Unit
) {
    BoxWithConstraints {
        val maxHeight = maxHeight
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = BottomNavigationHeight),
            verticalArrangement = Arrangement.Top,
        ) {
            Carrousel(
                modifier = Modifier.height(maxHeight * 0.4f),
                cards = viewModel.cards,
                setActions = { index ->
                    viewModel.setActions(index = index)
                }
            )
            Actions(
                modifier = Modifier.height(maxHeight * 0.6f),
                actions = viewModel.actions,
                onClick = onActionClick
            )
        }
    }
}