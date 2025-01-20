package org.uni.mobilecomputinghomework1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uni.mobilecomputinghomework1.ui.theme.MobileComputingHomework1Theme

@Composable
fun FoodItem(description: String, name: String, image: Int) {
    val backgroundColor = remember { mutableStateOf(Color.LightGray) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .background(backgroundColor.value)
            .border(
                width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(24.dp)
            )
            .clickable {
                backgroundColor.value =
                    if (backgroundColor.value == Color.LightGray) Color.DarkGray else Color.LightGray
            }
    ) {
        Image(
            modifier = Modifier
                .size(72.dp)
                .padding(start = 8.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(12.dp)),
            painter = painterResource(image),
            contentDescription = name,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.Gray)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = name,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Blue
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                text = description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodItemPreview() {
    MobileComputingHomework1Theme {
        FoodItem(
            description = "A beloved Italian dish made with a baked dough base, topped with tomato sauce, cheese, and a variety of toppings like vegetables or meat.",
            image = R.drawable.pizza_food,
            name = "Pizza"
        )
    }
}