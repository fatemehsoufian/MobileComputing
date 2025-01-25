package org.uni.mobilecomputinghomework1

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.uni.mobilecomputinghomework1.ui.theme.MobileComputingHomework1Theme

@Composable
fun HomeScreen(navController: NavController) {
    MobileComputingHomework1Theme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            items(FakeFoodData.foodList) {
                FoodItem(
                    description = it.description,
                    foodId = it.id,
                    navController = navController
                )
            }
        }
    }
}