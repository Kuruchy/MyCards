package com.kurulabs.mycards.ui.main.elements

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.data.sources.getDemoCards
import com.kurulabs.mycards.ui.about.About
import com.kurulabs.mycards.ui.cards.CardOverview
import com.kurulabs.mycards.ui.cards.models.CardActionItem
import com.kurulabs.mycards.ui.cards.state.CardsState
import com.kurulabs.mycards.ui.detail.elements.ActionDetail
import com.kurulabs.mycards.ui.detail.state.CardDetailState
import com.kurulabs.mycards.ui.errors.ErrorPage
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(
    scaffoldState: ScaffoldState,
    cardsState: CardsState,
    cardDetailState: CardDetailState,
    aboutButtonOnClick: () -> Unit,
    onActionClick: (CardActionItem.CardAction, Int) -> Unit
) {
    val navController = rememberNavController()
    var carrouselIndex by remember { mutableStateOf(0) }
    var selectedScreen: BottomNavigationScreens by remember { mutableStateOf(DEFAULT_SCREEN) }

    Scaffold(
        bottomBar = {
            val bottomNavigationItems = listOf(
                BottomNavigationScreens.Home,
                BottomNavigationScreens.About
            )

            BottomBar(
                selectedScreen = selectedScreen,
                items = bottomNavigationItems,
                onClick = { screen ->
                    if (selectedScreen != screen) {
                        selectedScreen = screen
                        navController.navigate(screen.route)
                    }
                }
            )
        },

        content = {
            NavHost(
                navController = navController,
                startDestination = DEFAULT_SCREEN.route
            ) {
                composable(BottomNavigationScreens.Home.route) {
                    when {
                        cardsState.isFailure -> ErrorPage()
                        cardsState.isLoading -> CardOverview(
                            cardsState = cardsState.copy(cards = getDemoCards()),
                            carrouselIndex = carrouselIndex,
                            onSwipe = { },
                            onActionClick = { }
                        )
                        else -> CardOverview(
                            cardsState = cardsState,
                            carrouselIndex = carrouselIndex,
                            onSwipe = { index -> carrouselIndex = index },
                            onActionClick = { cardAction ->
                                onActionClick.invoke(cardAction, carrouselIndex)
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
                    About(onClick = aboutButtonOnClick)
                }
            }
        },

        scaffoldState = scaffoldState
    )
}

private fun navigateUp(navController: NavController) {
    navController.navigateUp()
}
