import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.R
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.model.CardData
import com.kurulabs.mycards.ui.theme.MyCardsTheme

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
        Image(
            modifier = modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = cardData.icon.res),
            contentDescription = stringResource(id = R.string.a11y_card)
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            text = cardData.maskedNumber,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
    }
}