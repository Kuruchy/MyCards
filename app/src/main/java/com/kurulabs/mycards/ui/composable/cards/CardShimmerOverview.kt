package com.kurulabs.mycards.ui.composable.cards

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.composable.main.BottomNavigationHeight
import com.kurulabs.mycards.ui.theme.BankCardRoundedCornersShape
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import com.valentinilk.shimmer.shimmer

@Preview(showBackground = true)
@Composable
fun CardShimmerOverviewPreview() {
    MyCardsTheme {
        CardShimmerOverview()
    }
}

@Composable
fun CardShimmerOverview() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
    ) {
        val maxHeight = maxHeight
        Column(
            modifier = Modifier
                .padding(24.dp),
        ) {
            Card(
                modifier = Modifier
                    .height(maxHeight * 0.3f)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .padding(horizontal = 24.dp)
                    .shimmer(),
                backgroundColor = Color.LightGray,
                shape = BankCardRoundedCornersShape,
                elevation = 4.dp
            ) {}
            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )
            Column(
                modifier = Modifier
                    .height(maxHeight * 0.7f)
                    .fillMaxWidth(),
            ) {
                Card(
                    modifier = Modifier
                        .height(maxHeight * 0.1f)
                        .fillMaxWidth()
                        .shimmer(),
                    backgroundColor = Color.LightGray,
                    shape = BankCardRoundedCornersShape,
                    elevation = 4.dp
                ) {}
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                )
                Card(
                    modifier = Modifier
                        .height(maxHeight * 0.1f)
                        .fillMaxWidth()
                        .shimmer(),
                    backgroundColor = Color.LightGray,
                    shape = BankCardRoundedCornersShape,
                    elevation = 4.dp
                ) {}
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                )
                Card(
                    modifier = Modifier
                        .height(maxHeight * 0.1f)
                        .fillMaxWidth()
                        .shimmer(),
                    backgroundColor = Color.LightGray,
                    shape = BankCardRoundedCornersShape,
                    elevation = 4.dp
                ) {}
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                )
                Card(
                    modifier = Modifier
                        .height(maxHeight * 0.1f)
                        .fillMaxWidth()
                        .shimmer(),
                    backgroundColor = Color.LightGray,
                    shape = BankCardRoundedCornersShape,
                    elevation = 4.dp
                ) {}
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                )
                Card(
                    modifier = Modifier
                        .height(maxHeight * 0.1f)
                        .fillMaxWidth()
                        .shimmer(),
                    backgroundColor = Color.LightGray,
                    shape = BankCardRoundedCornersShape,
                    elevation = 4.dp
                ) {}
            }
        }
    }
}