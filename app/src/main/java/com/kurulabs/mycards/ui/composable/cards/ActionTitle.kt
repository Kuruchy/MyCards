import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.composable.utils.shimmer
import com.kurulabs.mycards.ui.models.cards.CardActionItem.GroupTitle
import com.kurulabs.mycards.ui.models.cards.CardActionItem.GroupTitle.PayGroupTitle
import com.kurulabs.mycards.ui.theme.MyCardsTheme

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    MyCardsTheme {
        ActionTitle(Modifier, PayGroupTitle, false)
    }
}


@Composable
internal fun ActionTitle(
    modifier: Modifier,
    cardTitle: GroupTitle,
    isLoading: Boolean
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(vertical = 16.dp)
            .shimmer(isLoading),
        text = cardTitle.title,
        style = typography.h6
    )
}
