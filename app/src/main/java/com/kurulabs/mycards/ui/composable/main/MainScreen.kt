package com.kurulabs.mycards.ui.composable.main

import android.content.Context
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.ui.state.CardViewModel
import com.kurulabs.mycards.ui.models.main.BottomNavigationScreens
import com.kurulabs.mycards.ui.composable.about.About
import com.kurulabs.mycards.ui.composable.cards.CardOverview

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(viewModel: CardViewModel, context: Context) {
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
            NavHost(navController, startDestination = DEFAULT_SCREEN.route) {
                composable(BottomNavigationScreens.Home.route) {
                    CardOverview(viewModel = viewModel, context = context)
                }
                composable(BottomNavigationScreens.About.route) {
                    About()
                }
            }
        },

        scaffoldState = scaffoldState
    )
}