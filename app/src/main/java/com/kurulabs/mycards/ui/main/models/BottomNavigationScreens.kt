package com.kurulabs.mycards.ui.main.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kurulabs.mycards.R

sealed class Screen(
    open val route: String
) {
    object Detail : Screen(route = "Detail")
}

sealed class BottomNavigationScreens(
    override val route: String,
    @StringRes val stringResId: Int,
    @DrawableRes val drawResId: Int
) : Screen(route) {
    object Home : BottomNavigationScreens(
        route = "Cards",
        stringResId = R.string.navigation_cards,
        drawResId = R.drawable.ic_credit_card
    )

    object About : BottomNavigationScreens(
        route = "About",
        stringResId = R.string.navigation_about,
        drawResId = android.R.drawable.ic_dialog_info
    )
}

val bottomNavigationScreens = listOf(
    BottomNavigationScreens.Home,
    BottomNavigationScreens.About
)