package org.uni.mobilecomputinghomework1

// AI disclaimer: the following descriptions for each food are generated by AI
object FakeFoodData {
    val foodList: List<Food> = listOf(
        Food(
            id = 0,
            image = R.drawable.cake_food,
            name = "Cake",
            description = "A sweet and fluffy baked dessert, often layered and frosted, perfect for celebrations and special occasions."
        ),
        Food(
            id = 1,
            image = R.drawable.cookie_food,
            name = "Cookie",
            description = "A small, flat, and crispy or chewy treat, typically baked with sugar, butter, and flour, often with chocolate chips or nuts."
        ),
        Food(
            id = 2,
            image = R.drawable.fish_food,
            name = "Fish",
            description = "A versatile and nutritious food, cooked in a variety of ways such as grilled, baked, or fried, often served with herbs and lemon."
        ),
        Food(
            id = 3,
            image = R.drawable.pancake_food,
            name = "Pancake",
            description = "A soft and fluffy breakfast delight made from a batter and cooked on a griddle, usually topped with syrup, butter, or fruits."
        ),
        Food(
            id = 4,
            image = R.drawable.pasta_food,
            name = "Pasta",
            description = "An Italian classic made from wheat and water, available in various shapes, served with sauces like marinara, Alfredo, or pesto."
        ),
        Food(
            id = 5,
            image = R.drawable.pizza_food,
            name = "Pizza",
            description = "A beloved Italian dish made with a baked dough base, topped with tomato sauce, cheese, and a variety of toppings like vegetables or meat."
        ),
        Food(
            id = 6,
            image = R.drawable.salad_food,
            name = "Salad",
            description = "A healthy mix of fresh vegetables, greens, and sometimes fruits, nuts, or proteins, dressed with vinaigrette or creamy sauces."
        ),
        Food(
            id = 7,
            image = R.drawable.sandwich_food,
            name = "Sandwich",
            description = "A convenient and tasty meal made with bread slices filled with a variety of ingredients like meats, cheeses, and vegetables."
        ),
        Food(
            id = 8,
            image = R.drawable.soup_food,
            name = "Soup",
            description = "A warm and comforting dish made by simmering vegetables, meat, or legumes in broth, perfect for a cozy meal."
        ),
        Food(
            id = 9,
            image = R.drawable.steak_food,
            name = "Steak",
            description = "A thick cut of beef, typically grilled or pan-seared to your preferred level of doneness, often served with sides like mashed potatoes or vegetables."
        ),
        Food(
            id = 10,
            image = R.drawable.burger_food,
            name = "Burger",
            description = "A ground beef patty, usually served in a soft bun with various toppings such as lettuce, tomato, cheese, pickles, and sauces."
        ),
        Food(
            id = 11,
            image = R.drawable.rice_food,
            name = "Rice",
            description = "A staple food made from boiled or steamed grains, commonly served as a side dish or as a base for various dishes like curries, stir-fries, or sushi."
        ),
        Food(
            id = 12,
            image = R.drawable.meatball_food,
            name = "Meatball",
            description = "Small, round pieces of ground meat, often mixed with breadcrumbs and spices, then baked, fried, or simmered in a sauce."
        ),
        Food(
            id = 13,
            image = R.drawable.stew_food,
            name = "Stew",
            description = "A hearty and comforting dish made by slowly simmering meat, vegetables, and spices in a flavorful broth, often served with bread or rice."
        ),
    )
}

data class Food(
    val id: Int,
    val image: Int,
    val name: String,
    val description: String
)

fun getFoodNameById(id: Int): String {
    return FakeFoodData.foodList.find { it.id == id }?.name ?: "pizza"
}

fun getFoodImageById(id: Int): Int {
    return FakeFoodData.foodList.find { it.id == id }?.image ?: R.drawable.pizza_food
}