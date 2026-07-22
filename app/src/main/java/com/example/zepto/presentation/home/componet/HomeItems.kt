package com.example.zepto.presentation.home.componet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.R
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
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val state by viewModel.uistate.collectAsState()
    var selectedCategory by remember { mutableStateOf(categoryList[0]) }
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val pullToRefreshState = rememberPullToRefreshState()
    
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
                
                Column(
                        modifier = Modifier.background(color = Color(0xFFD5BEFC))
                ) {
                    Box(
                            Modifier
                                    .fillMaxWidth(fraction = 0.8f)
                                    .height(70.dp)
                                    .padding(14.dp)
                                    .clip(shape = MaterialTheme.shapes.medium)
                                    .background(Color.White),
                            contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                                modifier = Modifier.padding(start = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                    imageVector = Icons.Outlined.Search,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                            )
                            Text(
                                    text = "Search for your accessories",
                                    fontSize = 12.sp,
                                    fontFamily = font
                            )
                        }
                    }
                    
                    CategoryTabBar(
                            categories = categoryList,
                            selectedCategory = selectedCategory,
                            onCategorySelected = { selectedCategory = it }
                    )
                }
                
                PullToRefreshBox(
                        state = pullToRefreshState,
                        isRefreshing = isRefreshing,
                        onRefresh = {
                            viewModel.refreshProducts()
                        }
                ) {
                    
                    LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        items(state.success!!.products) { items ->
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
}