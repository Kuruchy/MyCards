package com.kurulabs.mycards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kurulabs.mycards.ui.composable.main.MainScreen
import com.kurulabs.mycards.ui.state.CardViewModel
import com.kurulabs.mycards.ui.theme.MyCardsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardsTheme {
                MainScreen(viewModel, this)
            }
        }
    }
}