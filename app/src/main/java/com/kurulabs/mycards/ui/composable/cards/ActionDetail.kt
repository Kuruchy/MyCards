package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.demo.getDemoCards
import com.kurulabs.mycards.ui.models.cards.PressToInteract
import com.kurulabs.mycards.ui.models.cards.SwipeToInteract
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.Orange

@Preview(showBackground = true)
@Composable
fun ActionDetailPreview() {
    MyCardsTheme {
        ActionDetail(
            cardDataId = 0,
            cardActionId = 0,
            onBackClick = {}
        )
    }
}


@Composable
fun ActionDetail(
    modifier: Modifier = Modifier,
    cardDataId: Int,
    cardActionId: Int,
    onBackClick: () -> Unit,
) {
    val cardData = getDemoCards()[cardDataId]
    val cardAction = cardData.actions[cardActionId]
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val maxHeight = maxHeight
        Column(modifier = modifier.fillMaxSize()) {
            BoxWithConstraints(
                modifier = Modifier
                    .height(maxHeight * 0.22f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                BankCard(
                    modifier = Modifier
                        .aspectRatio(1.5f)
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                    cardData = cardData
                )
                CircularButton(
                    modifier = Modifier.align(Alignment.TopStart),
                    imageVector = Icons.Filled.ArrowBack
                ) {
                    onBackClick.invoke()
                }
            }
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                text = cardAction.name,
                style = MaterialTheme.typography.h5.copy(color = Orange, fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                text = cardAction.detailDescription,
                style = MaterialTheme.typography.body1
            )
            when (cardAction.interaction) {
                SwipeToInteract -> SwipeableButton(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    cardAction = cardAction
                )
                PressToInteract -> Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = cardAction.interactionText,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}