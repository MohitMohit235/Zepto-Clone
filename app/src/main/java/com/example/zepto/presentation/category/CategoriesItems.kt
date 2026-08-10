package com.example.zepto.presentation.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.data.model.Categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItems(
        navController: NavController,
        onBackMainClick: () -> Unit,
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
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
    
    Scaffold(
            
            topBar = {
                TopAppBar(
                        navigationIcon = {
                            IconButton(
                                    onClick = {
                                        onBackMainClick()
                                    }
                            ) {
                                Icon(
                                        imageVector = Icons.Outlined.ArrowBack,
                                        contentDescription = null,
                                        tint = Color.Black
                                )
                            }
                        },
                        title = {
                            Text(
                                    text = "Category",
                                    fontFamily = font
                            )
                        }
                )
            },
    ) { paddingValues ->
        
        LazyVerticalGrid(
                modifier = Modifier
                        .padding(30.dp)
                        .padding(paddingValues),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(category) { items ->
                CategoryCard(
                        image = items.image,
                        name = items.name
                )
            }
        }
    }
}