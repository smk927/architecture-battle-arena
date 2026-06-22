package com.example.architecturebattlearena.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.architecturebattlearena.features.arena.ArenaScreen
import com.example.architecturebattlearena.features.comparison.ComparisonScreen
import com.example.architecturebattlearena.features.history.HistoryScreen
import com.example.architecturebattlearena.features.home.HomeScreen
import com.example.architecturebattlearena.features.learning.LearningScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Arena.route) {
            ArenaScreen()
        }
        composable(Screen.Comparison.route) {
            ComparisonScreen()
        }
        composable(Screen.Learning.route) {
            LearningScreen()
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
    }
}
