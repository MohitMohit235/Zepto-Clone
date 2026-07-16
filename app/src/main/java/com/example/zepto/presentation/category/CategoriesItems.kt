package com.example.zepto.presentation.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.data.model.Categories

@Composable
fun CategoryItems( navController: NavController) {
    
    val category = listOf(
            Categories(
                    image = painterResource(R.drawable.fruits),
                    name = "Fruits & Vegetables"
            ),
            Categories(
                    image = painterResource(R.drawable.dairy),
                    name = "Dairy"
            ),
            Categories(
                    image = painterResource(R.drawable.bakery),
                    name = "Bakery"
            ),
            Categories(
                    image = painterResource(R.drawable.atta_rice_dal),
                    name = "Rice & Atta"
            ),
            Categories(
                    image = painterResource(R.drawable.snack),
                    name = "Snacks"
            ),
            Categories(
                    image = painterResource(R.drawable.beverages),
                    name = "Beverages"
            ),
            Categories(
                    image = painterResource(R.drawable.baby),
                    name = "Baby Care"
            ),
            Categories(
                    image = painterResource(R.drawable.care),
                    name = "Personal Care"
            ),
            Categories(
                    image = painterResource(R.drawable.clean),
                    name = "Clean"
            ),
            Categories(
                    image = painterResource(R.drawable.oils),
                    name = "Oils and Gee"
            ),
            Categories(
                    image = painterResource(R.drawable.care),
                    name = "Personal Care"
            )
    )
    
    LazyVerticalGrid(
            modifier = Modifier.padding(13.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(category){ items->
            CategoryCard(
                    image = items.image,
                    name = items.name
            )
        }
    }
}