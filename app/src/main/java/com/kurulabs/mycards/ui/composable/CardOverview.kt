package com.kurulabs.mycards.ui.composable

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kurulabs.mycards.CardViewModel
import com.kurulabs.mycards.ui.theme.MyCardsTheme


@Composable
fun CardOverview(viewModel: CardViewModel, context: Context) {
    MyCardsTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
        ) {
            Carrousel(viewModel)
            Actions(
                viewModel = viewModel,
                onClick = { cardAction ->
                    Toast.makeText(context, cardAction.name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}