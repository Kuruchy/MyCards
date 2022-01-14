package com.kurulabs.mycards.ui.composable.cards

import Action
import ActionTitle
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction

@Composable
internal fun Actions(
    modifier: Modifier,
    actions: List<CardAction>,
    onClick: (CardAction) -> Unit
) {
    LazyColumn(
        modifier = modifier.wrapContentWidth(),
    ) {
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