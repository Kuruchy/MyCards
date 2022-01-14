package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.R
import com.kurulabs.mycards.ui.demo.getDemoCards
import com.kurulabs.mycards.ui.models.cards.CardData
import com.kurulabs.mycards.ui.models.cards.getBackgroundColor
import com.kurulabs.mycards.ui.models.cards.getTextColor
import com.kurulabs.mycards.ui.composable.AutoResizeText
import com.kurulabs.mycards.ui.theme.BankCardRoundedCornersShape
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.bigFontRange
import com.kurulabs.mycards.ui.theme.smallFontRange
import java.util.*

@Preview(showBackground = true)
@Composable
fun BankCardPreview() {
    MyCardsTheme {
        BankCard(
            Modifier
                .width(120.dp), getDemoCards().first()
        )
    }
}


@Composable
internal fun BankCard(
    modifier: Modifier,
    cardData: CardData
) {
    BoxWithConstraints {
        val maxHeight = maxHeight
        Card(
            modifier = modifier,
            backgroundColor = cardData.getBackgroundColor(),
            shape = BankCardRoundedCornersShape,
            elevation = 4.dp
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                AutoResizeText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    text = cardData.bankName,
                    maxLines = 1,
                    fontSizeRange = bigFontRange,
                    style = typography.h1.copy(
                        color = cardData.getTextColor(),
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.End,
                )
                Image(
                    modifier = Modifier
                        .width(maxHeight * 0.16f)
                        .height(maxHeight * 0.16f)
                        .align(Alignment.Start),
                    painter = painterResource(id = R.drawable.chip),
                    contentDescription = null
                )
                AutoResizeText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = cardData.number,
                    maxLines = 1,
                    fontSizeRange = bigFontRange,
                    style = typography.body1.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
                AutoResizeText(
                    modifier = Modifier
                        .width(maxHeight * 0.3f)
                        .align(Alignment.End),
                    maxLines = 1,
                    fontSizeRange = smallFontRange,
                    text = cardData.validDate,
                    style = typography.body2.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.End,
                )
                AutoResizeText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    maxLines = 1,
                    fontSizeRange = smallFontRange,
                    text = cardData.owner.uppercase(Locale.getDefault()),
                    style = typography.h2.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}