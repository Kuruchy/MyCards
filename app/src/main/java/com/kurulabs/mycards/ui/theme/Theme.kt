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

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
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
        typography = typography,
        shapes = Shapes,
        content = content
    )
}