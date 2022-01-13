package com.kurulabs.mycards.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kurulabs.mycards.R

private val DarkColorPalette = darkColors(
    primary = Color(R.color.orange),
    primaryVariant = Color(R.color.orangeDark),
    secondary = Color(R.color.turquoise),
    onBackground = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Color(R.color.orange),
    primaryVariant = Color(R.color.orangeDark),
    secondary = Color(R.color.turquoise),
    onBackground = Color.Black,
)

lateinit var palette: Colors

@Composable
fun MyCardsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    palette = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = palette,
        shapes = Shapes,
        content = content
    )
}