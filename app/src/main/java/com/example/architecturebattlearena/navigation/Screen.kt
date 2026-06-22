package com.example.architecturebattlearena.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SportsMartialArts
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Dashboard", Icons.Default.Dashboard)
    object Arena : Screen("arena", "Architecture Arena", Icons.Default.SportsMartialArts)
    object Comparison : Screen("comparison", "Comparison Center", Icons.Default.Analytics)
    object Learning : Screen("learning", "Learning Center", Icons.Default.School)
    object History : Screen("history", "Event Timeline", Icons.Default.History)

    companion object {
        val items = listOf(Home, Arena, Comparison, Learning, History)
    }
}
