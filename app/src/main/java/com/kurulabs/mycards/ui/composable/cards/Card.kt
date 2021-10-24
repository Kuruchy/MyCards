import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.R
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.model.cards.CardData
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.typography

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MyCardsTheme {
        Card(Modifier, getDemoCards().first())
    }
}

@Composable
internal fun Card(modifier: Modifier = Modifier, cardData: CardData) {
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
            text = cardData.typeName,
            style = typography.h1,
            textAlign = TextAlign.Center,
        )
        Image(
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = cardData.icon.res),
            contentDescription = stringResource(id = R.string.a11y_card)
        )
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