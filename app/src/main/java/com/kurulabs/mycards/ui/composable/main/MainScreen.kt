package com.kurulabs.mycards.ui.composable.main

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kurulabs.mycards.ui.composable.about.About
import com.kurulabs.mycards.ui.composable.cards.ActionDetail
import com.kurulabs.mycards.ui.composable.cards.CardOverview
import com.kurulabs.mycards.ui.models.main.BottomNavigationScreens
import com.kurulabs.mycards.ui.state.CardViewModel

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(viewModel: CardViewModel) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

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
                    CardOverview(
                        viewModel = viewModel
                    ) { cardAction ->
                        val cardData = viewModel.card
                        val cardDataId = viewModel.cards.indexOf(cardData)
                        val cardActionId = viewModel.actions.indexOf(cardAction)
                        navController.navigate("${BottomNavigationScreens.Home.route}/${cardDataId}/${cardActionId}")
                    }
                }
                composable(
                    route = "${BottomNavigationScreens.Home.route}/{cardDataId}/{cardActionId}",
                    arguments = listOf(
                        navArgument("cardDataId") {
                            type = NavType.IntType
                        },
                        navArgument("cardActionId") {
                            type = NavType.IntType
                        }
                    )
                ) { navBackStackEntry ->
                    ActionDetail(
                        cardDataId = navBackStackEntry.arguments!!.getInt("cardDataId"),
                        cardActionId = navBackStackEntry.arguments!!.getInt("cardActionId"),
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

fun navigateUp(navController: NavController) {
    navController.navigateUp()
}
