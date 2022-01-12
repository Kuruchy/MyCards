package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurulabs.mycards.R
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.model.cards.CardData
import com.kurulabs.mycards.model.cards.getBackgroundColor
import com.kurulabs.mycards.model.cards.getTextColor
import com.kurulabs.mycards.ui.composable.AutoResizeText
import com.kurulabs.mycards.ui.composable.FontSizeRange
import com.kurulabs.mycards.ui.theme.BankCardRoundedCornersShape
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.typography
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun BankCardPreview() {
    MyCardsTheme {
        BankCard(
            Modifier
                .width(400.dp), getDemoCards().first()
        )
    }
}


@Composable
internal fun BankCard(
    modifier: Modifier,
    cardData: CardData
) {
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
                .padding(24.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                text = cardData.bankName,
                style = typography.h1.copy(color = cardData.getTextColor()),
                textAlign = TextAlign.End,
            )
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .align(Alignment.Start),
                painter = painterResource(id = R.drawable.chip),
                contentDescription = null
            )
            AutoResizeText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = cardData.number,
                maxLines = 1,
                fontSizeRange = FontSizeRange(
                    min = 10.sp,
                    max = 30.sp,
                ),
                overflow = TextOverflow.Visible,
                style = MaterialTheme.typography.body1.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = cardData.validDate,
                style = typography.body2.copy(color = Color.White),
                textAlign = TextAlign.End,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = cardData.owner.uppercase(Locale.getDefault()),
                style = typography.h2.copy(color = Color.White),
                textAlign = TextAlign.Start,
            )
        }
    }
}