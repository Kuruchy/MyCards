package com.kurulabs.mycards.ui

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.CardViewModel
import com.kurulabs.mycards.R
import com.kurulabs.mycards.model.main.BottomNavigationScreens
import com.kurulabs.mycards.ui.composable.about.About
import com.kurulabs.mycards.ui.composable.cards.CardOverview
import com.kurulabs.mycards.ui.theme.typography

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(viewModel: CardViewModel, context: Context) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = typography.h1
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        },

        bottomBar = {
            val bottomNavigationItems = listOf(
                BottomNavigationScreens.Home,
                BottomNavigationScreens.About
            )

            MainBottomBar(
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