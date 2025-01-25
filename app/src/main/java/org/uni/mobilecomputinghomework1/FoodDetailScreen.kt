package org.uni.mobilecomputinghomework1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.uni.mobilecomputinghomework1.ui.theme.MobileComputingHomework1Theme

@Composable
fun FoodDetailScreen(foodId: Int, navController: NavController) {
    val foodName = getFoodNameById(foodId)
    val foodImage = getFoodImageById(foodId)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = foodName,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 40.sp, textDecoration = TextDecoration.Underline)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            modifier = Modifier
                .size(212.dp)
                .clip(RoundedCornerShape(48.dp))
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(48.dp)),
            painter = painterResource(foodImage),
            contentScale = ContentScale.FillBounds,
            contentDescription = "food image"
        )
        Spacer(modifier = Modifier.height(92.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.DarkGray
                ), onClick = {
                    val previousFoodId =
                        (foodId - 1 + FakeFoodData.foodList.size) % FakeFoodData.foodList.size
                    navController.navigate(Screens.Food.createRoute(id = previousFoodId)) {
                        popUpTo(Screens.Food.route.replace("{foodId}", "$foodId")) {
                            inclusive = true
                        }
                    }
                }
            ) {
                Text(stringResource(R.string.label_previous))
            }
            Button(
                modifier = Modifier.weight(1f),
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.DarkGray
                ), onClick = {
                    val nextFoodId = (foodId + 1) % (FakeFoodData.foodList.size)
                    navController.navigate(Screens.Food.createRoute(id = nextFoodId)) {
                        popUpTo(Screens.Food.route.replace("{foodId}", "$foodId")) {
                            inclusive = true
                        }
                    }
                }
            ) {
                Text(stringResource(R.string.label_next))
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.DarkGray
            ), onClick = {
                navController.popBackStack(Screens.Home.route, inclusive = false)
            }
        ) {
            Text(stringResource(R.string.label_home))
        }
    }
}

@Preview
@Composable
fun FoodDetailScreenPreview() {
    MobileComputingHomework1Theme {
        FoodDetailScreen(
            foodId = 6,
            navController = rememberNavController()
        )
    }
}