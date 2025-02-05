package org.uni.mobilecomputinghomework1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uni.mobilecomputinghomework1.addfood.AddFoodScreen
import org.uni.mobilecomputinghomework1.detail.FoodDetailScreen
import org.uni.mobilecomputinghomework1.home.HomeScreen

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
        composable(route = Screens.AddFood.route) {
            AddFoodScreen(navController = navController)
        }
    }
}