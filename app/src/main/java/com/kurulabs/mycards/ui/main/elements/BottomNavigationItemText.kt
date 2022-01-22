package com.kurulabs.mycards.ui.main.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens

@Composable
internal fun BottomNavigationItemText(screen: BottomNavigationScreens) {
    Text(
        modifier = Modifier,
        text = stringResource(id = screen.stringResId)
    )
}