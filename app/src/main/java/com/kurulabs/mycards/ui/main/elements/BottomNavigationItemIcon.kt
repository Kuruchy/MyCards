package com.kurulabs.mycards.ui.main.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens

@Composable
internal fun BottomNavigationItemIcon(screen: BottomNavigationScreens) {
    Icon(
        modifier = Modifier.padding(bottom = 4.dp),
        painter = painterResource(id = screen.drawResId),
        contentDescription = stringResource(id = screen.stringResId)
    )
}
