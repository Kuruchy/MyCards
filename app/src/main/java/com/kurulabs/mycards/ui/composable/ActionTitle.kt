import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.model.CardActionItem.GroupTitle
import com.kurulabs.mycards.model.CardActionItem.GroupTitle.PayGroupTitle
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.kurulabs.mycards.ui.theme.typography

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    MyCardsTheme {
        ActionTitle(Modifier, PayGroupTitle)
    }
}


@Composable
internal fun ActionTitle(modifier: Modifier, cardTitle: GroupTitle) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(vertical = 16.dp),
        text = cardTitle.title,
        style = typography.h2
    )
}
