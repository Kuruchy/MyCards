import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.model.cards.CardData
import com.kurulabs.mycards.ui.composable.cards.BankCard
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.typography

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MyCardsTheme {
        CarrouselItem(Modifier, getDemoCards().first())
    }
}

@Composable
internal fun CarrouselItem(modifier: Modifier = Modifier, cardData: CardData) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .padding(horizontal = 8.dp),
            text = cardData.typeName.description,
            style = typography.h1,
            textAlign = TextAlign.Center,
        )
        BankCard(modifier.align(Alignment.CenterHorizontally), cardData)
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 8.dp),
            text = cardData.owner,
            style = typography.h2,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp)
                .padding(bottom = 16.dp),
            text = cardData.maskedNumber,
            style = typography.subtitle1,
            textAlign = TextAlign.Center,
        )
    }
}