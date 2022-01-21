package com.kurulabs.mycards.ui.main.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kurulabs.mycards.ui.main.models.BottomNavigationScreens
import com.kurulabs.mycards.ui.theme.Orange

private lateinit var selectedIndex: MutableState<Int>

val BottomNavigationHeight = 56.dp

@Composable
fun BottomBar(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {

    BottomNavigation(
        backgroundColor = Orange
    ) {

        selectedIndex = remember { mutableStateOf(0) }

        items.forEachIndexed { index, screen ->

            val isSelected = selectedIndex.value == index

            BottomNavigationItem(
                modifier = Modifier.background(color = MaterialTheme.colors.background),
                icon = {
                    Icon(
                        modifier = Modifier.padding(bottom = 4.dp),
                        painter = painterResource(id = screen.drawResId),
                        contentDescription = stringResource(id = screen.stringResId)
                    )
                },
                label = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = screen.stringResId),
                        style = getLabelTextStyle(isSelected)
                    )
                },
                selected = isSelected,
                selectedContentColor = Orange,
                unselectedContentColor = MaterialTheme.colors.onBackground.copy(0.3f),
                alwaysShowLabel = true,
                onClick = {
                    if (!isSelected) {
                        selectedIndex.value = index
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun getLabelTextStyle(isSelected: Boolean) = if (isSelected) {
    MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold, color = Orange)
} else {
    MaterialTheme.typography.subtitle1.copy(color = MaterialTheme.colors.onBackground.copy(0.3f))
}