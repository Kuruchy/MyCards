package com.kurulabs.mycards

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.kurulabs.mycards.ui.cards.state.CardViewModel
import com.kurulabs.mycards.ui.main.elements.MainScreen
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.update

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
            val cardsState by viewModel.cardsState.collectAsState()
            val cardDetailState by viewModel.cardDetailState.collectAsState()

            val navController = rememberNavController()

            MyCardsTheme {
                MainScreen(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    cardsState = cardsState,
                    cardDetailState = cardDetailState,
                    aboutButtonOnClick = ::navigateToGitHub,
                    onActionClick = { cardAction, index ->
                        viewModel.cardDetailState.update {
                            it.copy(
                                cardData = cardsState.cards[index],
                                cardAction = cardAction
                            )
                        }
                    }
                )
            }
        }
    }

    private fun navigateToGitHub() = startActivity(
        Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.gitHubLink)))
    )
}