package com.example.zepto.presentation.home.componet

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.zepto.presentation.carts.cartviewmodel.CartViewModel
import com.example.zepto.presentation.home.componet.tabbar.CategoryTabBar
import com.example.zepto.presentation.home.componet.tabbar.categoryList
import com.example.zepto.presentation.home.viewmodel.ProductViewModel
import com.example.zepto.presentation.navigation.Screen
import com.example.zepto.presentation.product.ProductCard
import kotlinx.coroutines.launch

@Composable
fun ProductList(
        navController: NavController,
        viewModel: ProductViewModel = hiltViewModel(),
        cartViewModel: CartViewModel = hiltViewModel(),
        onAddress: () -> Unit,
) {
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val state by viewModel.uistate.collectAsState()
    var selectedCategory by remember { mutableStateOf(categoryList[0]) }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val listState = rememberLazyListState()
    
    val isScrolled by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 20
        }
    }
    
    val topHeight by animateDpAsState(
            targetValue = if (isScrolled) 40.dp else 20.dp,
            label = "TopHeight"
    )
    
    val backgroundColor by animateColorAsState(
            targetValue = if (isScrolled)
                Color.White
            else
                Color(0xFFD5BEFC),
            label = ""
    )
    
    ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(
                        onItemClick = { },
                        onClose = {
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        onAddressClick = {
                            navController.navigate(Screen.AddressScreen.route)
                        }
                )
            }
    
    ) {
        
        LazyColumn(
                state = listState
        ) {
            
            item {
                HomeTopBar(
                        navController = navController,
                        onAddressClick = {
                            onAddress()
                        },
                        OnClickOpen = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                )
            }
            
            stickyHeader {
                Column(
                        modifier = Modifier.background(backgroundColor)
                                .padding(top = topHeight)
                ) {
                    Box(
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .height(75.dp)
                                    .padding(14.dp)
                                    .clip(MaterialTheme.shapes.medium)
                                    .background(Color.White)
                                    .border(
                                            width = 1.5.dp,
                                            color = Color(0xFFD5BEFC),
                                            shape = MaterialTheme.shapes.medium
                                    ),
                            contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                                modifier = Modifier.padding(start = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                    imageVector = Icons.Outlined.Search,
                                    contentDescription = null
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
                            onCategorySelected = {
                                selectedCategory = it
                            }
                    )
                }
            }
            
            items(state.success!!.products.chunked(5)) { rowProducts ->
                
                LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp)
                ) {
                    
                    items(rowProducts) { product ->
                        
                        ProductCard(
                                product = product,
                                onProductScreen = {
                                    navController.navigate(
                                            Screen.ProductDetailScreen.createRoute(product.id)
                                    )
                                },
                                onAddClick = {
                                    cartViewModel.addCart(product = product)
                                }
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}