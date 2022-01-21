package com.kurulabs.mycards.ui.composable.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.theme.BaseRoundedCornersShape
import com.kurulabs.mycards.ui.theme.Orange

@Composable
fun About(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(24.dp),
        shape = BaseRoundedCornersShape
    ) {
        Column() {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                text = "🔥",
                style = typography.h1
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                text = "MyCards",
                style = typography.h4.copy(color = Orange)
            )
            Text(
                modifier = Modifier.padding(24.dp),
                text = "MyCards is a small demo application that demonstrates modern Android Architecture based on MVVM.\n\nIt uses Hilt, Coroutines, Flow, StateFlow, ViewModel, Jetpack Compose and Accompanist.",
                style = typography.body1,
                textAlign = TextAlign.Center
            )
            Button(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = onClick
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    text = "More Info",
                    style = typography.body1
                )
            }
        }
    }
}