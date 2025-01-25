package org.uni.mobilecomputinghomework1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Food.route) {
            val foodId = it.arguments?.getString("id")?.toIntOrNull() ?: 6
            FoodDetailScreen(
                foodId = foodId,
                navController = navController
            )
        }
    }
}