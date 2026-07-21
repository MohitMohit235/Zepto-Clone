package com.example.zepto.presentation.onbordingscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zepto.presentation.category.CategoryItems
import com.example.zepto.presentation.home.componet.DrawerContent
import com.example.zepto.presentation.home.componet.HomeBottomBar
import com.example.zepto.presentation.home.componet.HomeItems
import com.example.zepto.presentation.home.componet.HomeTopBar
import com.example.zepto.presentation.home.componet.tabbar.CategoryTabBar
import com.example.zepto.presentation.home.componet.tabbar.categoryList
import com.example.zepto.presentation.navigation.Screen
import com.example.zepto.presentation.orders.OrderItems
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainZeptoScreen(
        navController: NavController,
        onAddress:()-> Unit,
        OnCartClick: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val bottomNavController = rememberNavController()
    
    
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
        
        Scaffold(
                modifier = Modifier
                        .fillMaxSize(),
                topBar = {
                        HomeTopBar(
                                navController = navController,
                                OnClickOpen = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                },
                                onAddressClick = {
                                    onAddress()
                                }
                        )
                },
                bottomBar = {
                    HomeBottomBar(navController = bottomNavController)
                }
        
        ) { paddingValues ->
            NavHost(
                    navController = bottomNavController,
                    startDestination = "home",
                    modifier = Modifier.padding(paddingValues)
            ) {
                composable("home") {
                    HomeItems(
                            navController
                    )
                }
                
                composable("categories") {
                    CategoryItems(navController = bottomNavController)
                }
                
                composable("orders") {
                    OrderItems(
                            navController = bottomNavController,
                    )
                }
                composable("cart") {
                    CartScreen(
                            bottomNavController,
                            OnBackMainClick = {
                                bottomNavController.navigate(route = "home") {
                                    popUpTo("cart") { inclusive = true }
                                }
                            })
                }
            }
        }
    }
}