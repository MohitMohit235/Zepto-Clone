package com.example.zepto.presentation.home.componet.tabbar

data class CategoryModel(
        val name: String,
        val imageUrl: String
)



val categoryList = listOf(
        CategoryModel(
                name = "All",
                imageUrl = "https://img.magnific.com/premium-vector/food-item-vector-illustration_927344-47289.jpg?semt=ais_hybrid&w=740&q=80"
        ),
        CategoryModel(
                name = "Fruits",
                imageUrl = "https://e7.pngegg.com/pngimages/312/149/png-clipart-kinnow-orange-drink-fruit-mandarin-orange-orange-natural-foods-food-thumbnail.png"
        ),
        CategoryModel(
                name = "Bakery",
                imageUrl = "https://cdn-icons-png.flaticon.com/512/10606/10606118.png"
        ),
        CategoryModel(
                name = "Snacks",
                imageUrl = "https://www.shutterstock.com/image-vector/fast-junk-food-unhealthy-snacks-260nw-2403845055.jpg"
        ),
        CategoryModel(
                name = "Beverages",
                imageUrl = "https://thumbs.dreamstime.com/b/cans-beverages-19492376.jpg"
        ),
        CategoryModel(
                name = "Personal Care",
                imageUrl = "https://media.istockphoto.com/id/682190248/vector/shopping-basket-with-tubes.jpg?s=612x612&w=0&k=20&c=mA1wl8h_8jnxZnFGW8oFySfecFLNJ2FPy9Hb4SOry4M="
        )
)