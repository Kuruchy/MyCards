package com.kurulabs.mycards.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kurulabs.mycards.R

private val DarkColorPalette = darkColors(
    primary = Color(R.color.orange),
    primaryVariant = Color(R.color.orangeDark),
    secondary = Color(R.color.turquoise)
)

private val LightColorPalette = lightColors(
    primary = Color(R.color.orange),
    primaryVariant = Color(R.color.orangeDark),
    secondary = Color(R.color.turquoise)

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyCardsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}