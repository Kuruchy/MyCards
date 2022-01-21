package com.kurulabs.mycards.ui.composable.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

fun Modifier.shimmer(isLoading: Boolean): Modifier = composed {
    val isDarkMode = isSystemInDarkTheme()

    placeholder(
        visible = isLoading,
        color = if(isDarkMode) Color.DarkGray else Color.LightGray,
        shape = RoundedCornerShape(16.dp),
        highlight = PlaceholderHighlight.shimmer(
            highlightColor = Color.Gray,
        ),
    )
}