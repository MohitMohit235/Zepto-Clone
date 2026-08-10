package com.example.zepto.presentation.home.componet

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.zepto.R
import com.example.zepto.data.model.bottomNavItem
import com.example.zepto.presentation.carts.cartviewmodel.CartViewModel

@Composable
fun HomeBottomBar(
        navController: NavController,
) {
    val cartViewModel: CartViewModel = hiltViewModel()
    val cartItems by cartViewModel.cartItems.collectAsState()
    val badgeCount = cartItems.sumOf { it.quantity }
    val font = FontFamily(Font(R.font.mainfonts))
    
    val navItems = listOf(
            bottomNavItem.Home,
            bottomNavItem.Categories,
            bottomNavItem.Order,
            bottomNavItem.Cart
    )
    NavigationBar(
            containerColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route
        navItems.forEach { item ->
            NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF8341A2),
                            selectedTextColor = Color(0xFF8341A2),
                            unselectedIconColor = Color.DarkGray,
                            unselectedTextColor = Color.DarkGray
                    ),
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(
                                    navController.graph.startDestinationId
                            ) {
                                saveState = true
                            }
                            
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        
                        if (item.route == "cart") {
                            
                            BadgedBox(
                                    badge = {
                                        if (badgeCount > 0) {
                                            Badge {
                                                Text(badgeCount.toString())
                                            }
                                        }
                                    }
                            ) {
                                Icon(
                                        imageVector = item.icon,
                                        contentDescription = null
                                )
                            }
                            
                        } else {
                            
                            Icon(
                                    imageVector = item.icon,
                                    contentDescription = null
                            )
                            
                        }
                    },
                    label = {
                        Text(
                                text = item.label,
                                fontFamily = font
                        )
                    }
            )
        }
    }
}