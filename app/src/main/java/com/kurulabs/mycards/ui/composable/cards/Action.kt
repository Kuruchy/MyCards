import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.composable.utils.shimmer
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.ui.theme.MyCardsTheme

@Preview(
    showBackground = true
)
@Composable
fun ActionPreview() {
    MyCardsTheme {
        Action(Modifier, CancelCard, false) {}
    }
}

@Composable
internal fun Action(
    modifier: Modifier = Modifier,
    cardAction: CardAction,
    isLoading: Boolean,
    onClickAction: (CardAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClickAction(cardAction)
            }
            .padding(16.dp)
    ) {
        Image(
            modifier = modifier
                .width(width = 40.dp)
                .padding(all = 4.dp)
                .align(alignment = Alignment.CenterVertically)
                .wrapContentHeight()
                .shimmer(isLoading),
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
                    .padding(top = 8.dp)
                    .shimmer(isLoading),
                text = cardAction.name,
                style = typography.body1
            )
            CompositionLocalProvider(LocalContentAlpha provides medium) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp)
                        .padding(bottom = 8.dp)
                        .shimmer(isLoading),
                    text = cardAction.description,
                    style = typography.subtitle1
                )
            }
        }
    }
}