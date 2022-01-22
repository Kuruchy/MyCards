package com.kurulabs.mycards.ui.main.elements

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens
import com.kurulabs.mycards.ui.theme.Orange

val BottomNavigationHeight = 56.dp

@Composable
internal fun BottomBar(
    items: List<BottomNavigationScreens>,
    navBackStackEntry: NavBackStackEntry?,
    onClick: (String) -> Unit,
) {
    BottomNavigation(
        backgroundColor = Orange
    ) {
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(color = MaterialTheme.colors.background),
                icon = { BottomNavigationItemIcon(screen) },
                label = { BottomNavigationItemText(screen) },
                selected = currentRoute == screen.route,
                selectedContentColor = Orange,
                unselectedContentColor = MaterialTheme.colors.onBackground.copy(0.3f),
                alwaysShowLabel = true,
                onClick = { onClick.invoke(screen.route) }
            )
        }
    }
}
