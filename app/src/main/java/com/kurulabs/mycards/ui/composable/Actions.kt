package com.kurulabs.mycards.ui.composable

import Action
import ActionTitle
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.CardViewModel
import com.kurulabs.mycards.model.CardActionItem.CardAction


@Composable
internal fun Actions(
    viewModel: CardViewModel,
    onClick: (CardAction) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(horizontal = 8.dp)
            .background(color = MaterialTheme.colors.background),
    ) {
        val actions = viewModel.actions.value
        actions.groupBy { it.groupTitle.index }.forEach { (_, actions) ->
            item {
                ActionTitle(modifier = Modifier, actions.first().groupTitle)
            }
            items(actions) { action ->
                Action(cardAction = action) { onClick.invoke(action) }
            }
        }
    }
}