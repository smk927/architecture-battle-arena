package com.example.architecturebattlearena.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Accent,
    secondary = TextSecondary,
    tertiary = Success,
    background = Background,
    surface = CardBackground,
    onPrimary = Color.Black,
    onSecondary = TextPrimary,
    onTertiary = Color.White,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    error = Error
)

@Composable
fun ArchitectureBattleArenaTheme(
    // Force dark theme as per project overview
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}