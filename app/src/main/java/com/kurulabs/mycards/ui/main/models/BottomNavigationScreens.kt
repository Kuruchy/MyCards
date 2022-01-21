package com.kurulabs.mycards.ui.main.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kurulabs.mycards.R

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val stringResId: Int,
    @DrawableRes val drawResId: Int
) {
    object Home : BottomNavigationScreens("Cards", R.string.navigation_cards, R.drawable.ic_credit_card)
    object About : BottomNavigationScreens("About", R.string.navigation_about, android.R.drawable.ic_dialog_info)
}
