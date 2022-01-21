package com.kurulabs.mycards

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kurulabs.mycards.ui.main.elements.MainScreen
import com.kurulabs.mycards.ui.cards.state.CardViewModel
import com.kurulabs.mycards.ui.theme.MyCardsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardsTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToGitHub = ::navigateToGitHub
                )
            }
        }
    }

    private fun navigateToGitHub() = startActivity(
        Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.gitHubLink)))
    )
}