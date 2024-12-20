package com.talaniacodes.mealprepcalendar.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = LightAccent,
    background = LightBackground,
    surface = LightSecondaryText,
    onPrimary = LightPrimaryText,
    onBackground = LightSecondaryText,
    error = LightNegative
)

private val DarkColorPalette = darkColors(
    primary = DarkAccent,
    background = DarkBackground,
    surface = DarkCardBackground,
    onPrimary = DarkPrimaryText,
    onBackground = DarkSecondaryText,
    error = DarkNegative
)

@Composable
fun MealPrepyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit)
{
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

