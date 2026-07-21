package com.example.zepto.presentation.home.componet

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.presentation.home.componet.tabbar.CategoryTabBar
import com.example.zepto.presentation.home.componet.tabbar.categoryList
import com.example.zepto.presentation.home.viewmodel.ProductViewModel
import com.example.zepto.presentation.navigation.Screen
import com.example.zepto.presentation.product.ProductCard

@Composable
fun HomeItems(
        navController: NavController,
        viewModel: ProductViewModel = hiltViewModel(),
) {
    
    val state by viewModel.uistate.collectAsState()
    var selectedCategory by remember { mutableStateOf(categoryList[0]) }
    
    when {
        
        state.isLoading -> {
            Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        
        state.failure != null -> {
            Text(text = state.failure!!)
        }
        
        state.success != null -> {
            
            Column(
                    modifier = Modifier.fillMaxSize()
            ) {
                
                CategoryTabBar(
                        categories = categoryList,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                )
                
                LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    items(state.success!!.products) { items ->
                        Box(
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                        ) {
                        
                        }
                        ProductCard(
                                productName = items.title,
                                productImage = items.thumbnail,
                                productCategory = items.category,
                                productPrice = items.price.toString(),
                                productRating = items.rating,
                                onProductScreen = {
                                    navController.navigate(
                                            Screen.ProductDetailScreen.createRoute(
                                                    items.id
                                            )
                                    )
                                    Log.d("TAB", items.id.toString())
                                },
                        )
                    }
                }
            }
        }
    }
}