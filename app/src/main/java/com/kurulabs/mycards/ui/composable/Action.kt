import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurulabs.mycards.demo.getDemoActions
import com.kurulabs.mycards.model.CardActionItem
import com.kurulabs.mycards.model.CardActionItem.CardAction
import com.kurulabs.mycards.model.CardActionItem.GroupTitle
import com.kurulabs.mycards.ui.theme.MyCardsTheme

@Preview(showBackground = true)
@Composable
fun ActionPreview() {
    MyCardsTheme {
        Action(Modifier, getDemoActions().last())
    }
}

@Composable
internal fun Action(
    modifier: Modifier = Modifier,
    cardActionItem: CardActionItem
) {
    when (cardActionItem) {
        is GroupTitle -> Title(modifier = modifier, cardTitle = cardActionItem)
        is CardAction -> Action(modifier = modifier, cardAction = cardActionItem)
    }
}

@Composable
private fun Title(modifier: Modifier, cardTitle: GroupTitle) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(vertical = 16.dp),
        text = cardTitle.title,
        color = MaterialTheme.colors.onBackground,
        textAlign = TextAlign.Start,
        fontSize = 16.sp
    )
}

@Composable
private fun Action(modifier: Modifier, cardAction: CardAction) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = modifier
                .width(width = 40.dp)
                .padding(all = 4.dp)
                .align(alignment = Alignment.CenterVertically)
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = cardAction.icon),
            contentDescription = null
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = cardAction.title,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp)
                    .padding(bottom = 8.dp),
                text = cardAction.subtitle,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f),
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )
        }
    }
}
