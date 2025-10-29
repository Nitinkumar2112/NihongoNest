package com.jet.japapp.ui.theme // Make sure this package name is correct

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = IndigoPrimaryLight,
    secondary = IndigoSecondaryLight,
    tertiary = CoralTertiaryLight,
    background = WhiteBackgroundLight,
    surface = WhiteBackgroundLight,
    error = RedErrorLight,

    // Defines the color of text and icons ON TOP OF the colors above
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F), // Dark text on light background
    onSurface = Color(0xFF1C1B1F),    // Dark text on light background
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = IndigoPrimaryDark,
    secondary = SlateSecondaryDark,
    tertiary = CoralTertiaryDark,
    background = DarkBackgroundDark,
    surface = DarkSurfaceDark,
    error = RedErrorDark,

    // Defines the color of text and icons ON TOP OF the colors above
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFFE6E1E5), // Light text on dark background
    onSurface = Color(0xFFE6E1E5),    // Light text on dark background
    onError = Color.Black
)

@Composable
fun JapappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Set to false to always use your custom theme
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}