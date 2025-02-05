package org.uni.mobilecomputinghomework1.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.uni.mobilecomputinghomework1.R
import org.uni.mobilecomputinghomework1.Screens

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val foodList by viewModel.foodList.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                modifier = Modifier
                    .size(64.dp),
                onClick = { navController.navigate(Screens.AddFood.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.label_add)
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(foodList) { food ->
                FoodItem(
                    food = food,
                    navController = navController,
                )
            }
        }
    }
}