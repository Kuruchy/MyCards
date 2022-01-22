package com.kurulabs.mycards.ui.main.elements

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kurulabs.mycards.data.sources.getDemoCards
import com.kurulabs.mycards.ui.about.About
import com.kurulabs.mycards.ui.cards.CardOverview
import com.kurulabs.mycards.ui.cards.models.CardActionItem
import com.kurulabs.mycards.ui.cards.state.CardsState
import com.kurulabs.mycards.ui.detail.elements.ActionDetail
import com.kurulabs.mycards.ui.detail.state.CardDetailState
import com.kurulabs.mycards.ui.errors.ErrorPage
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens.About
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens.Home
import com.kurulabs.mycards.ui.main.models.Screen.Detail
import com.kurulabs.mycards.ui.main.models.bottomNavigationScreens

@Composable
fun MainScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    cardsState: CardsState,
    cardDetailState: CardDetailState,
    aboutButtonOnClick: () -> Unit,
    onActionClick: (CardActionItem.CardAction, Int) -> Unit
) {
    var carrouselIndex by remember { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomBar(
                navBackStackEntry = navBackStackEntry,
                items = bottomNavigationScreens,
                onClick = { route ->
                    navController.navigate(route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },

        content = {
            NavHost(
                navController = navController,
                startDestination = Home.route
            ) {
                composable(Home.route) {
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
                                navController.navigate(Detail.route)
                            }
                        )
                    }
                }
                composable(Detail.route) {
                    ActionDetail(
                        cardDetailState = cardDetailState,
                        onBackClick = { navController.navigateUp() }
                    )
                }
                composable(About.route) {
                    About(onClick = aboutButtonOnClick)
                }
            }
        },

        scaffoldState = scaffoldState
    )
}
