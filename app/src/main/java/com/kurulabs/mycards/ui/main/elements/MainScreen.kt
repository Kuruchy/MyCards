package com.kurulabs.mycards.ui.main.elements

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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.data.sources.getDemoCards
import com.kurulabs.mycards.ui.about.About
import com.kurulabs.mycards.ui.cards.CardOverview
import com.kurulabs.mycards.ui.detail.elements.ActionDetail
import com.kurulabs.mycards.ui.errors.ErrorPage
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens
import com.kurulabs.mycards.ui.cards.state.CardViewModel
import kotlinx.coroutines.flow.update

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(viewModel: CardViewModel, navigateToGitHub: () -> Unit) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    var carrouselIndex by remember { mutableStateOf(0) }
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
                                viewModel.cardDetailState.update {
                                    it.copy(
                                        cardData = cardsState.cards[carrouselIndex],
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
                    About(onClick = navigateToGitHub)
                }
            }
        },

        scaffoldState = scaffoldState
    )
}

private fun navigateUp(navController: NavController) {
    navController.navigateUp()
}
