package com.kurulabs.mycards.ui.errors

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.theme.BaseRoundedCornersShape
import com.kurulabs.mycards.ui.theme.Orange

@Composable
fun ErrorPage() {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(24.dp),
        shape = BaseRoundedCornersShape
    ) {
        Column() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(16.dp),
                imageVector = Icons.Filled.Warning,
                colorFilter = ColorFilter.tint(Orange),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Sorry!",
                style = MaterialTheme.typography.h4.copy(color = Orange)
            )
            Text(
                modifier = Modifier.padding(24.dp),
                text = "There was an error trying to get the cards. Please try again later.",
                style = MaterialTheme.typography.body1
            )
        }
    }
}
