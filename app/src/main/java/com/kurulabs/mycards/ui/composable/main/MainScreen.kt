package com.kurulabs.mycards.ui.composable.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.ui.composable.about.About
import com.kurulabs.mycards.ui.composable.cards.ActionDetail
import com.kurulabs.mycards.ui.composable.cards.CardOverview
import com.kurulabs.mycards.ui.composable.cards.CardShimmerOverview
import com.kurulabs.mycards.ui.models.main.BottomNavigationScreens
import com.kurulabs.mycards.ui.state.CardViewModel
import com.kurulabs.mycards.ui.theme.BankCardRoundedCornersShape
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.update

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(viewModel: CardViewModel) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    var carouselIndex by remember { mutableStateOf(0) }
    val cardsState by viewModel.cardsState.collectAsState()
    val cardDetailState by viewModel.cardDetailState.collectAsState()

    Scaffold(
        bottomBar = {
            val bottomNavigationItems = listOf(
                BottomNavigationScreens.Home,
                BottomNavigationScreens.About
            )

            BottomBar(
                navController = navController,
                items = bottomNavigationItems
            )
        },

        content = {
            NavHost(
                navController = navController,
                startDestination = DEFAULT_SCREEN.route
            ) {
                composable(BottomNavigationScreens.Home.route) {
                    if (cardsState.isLoading) {
                        CardShimmerOverview()
                    } else {
                        CardOverview(
                            cardsState = cardsState,
                            onSwipe = { index -> carouselIndex = index },
                            onActionClick = { cardAction ->
                                viewModel.cardDetailState.update {
                                    it.copy(
                                        cardData = cardsState.cards[carouselIndex],
                                        cardAction = cardAction
                                    )
                                }
                                navController.navigate("Detail")
                            }
                        )
                    }
                }
                composable("Detail") {
                    ActionDetail(
                        cardDetailState = cardDetailState,
                        onBackClick = { navigateUp(navController) }
                    )
                }
                composable(BottomNavigationScreens.About.route) {
                    About()
                }
            }
        },

        scaffoldState = scaffoldState
    )
}

private fun navigateUp(navController: NavController) {
    navController.navigateUp()
}
