package com.example.zepto.presentation.home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.zepto.data.model.bottomNavItem

@Composable
fun HomeBottomBar(
        navController: NavController,
) {
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
                    icon = { Icon(imageVector = item.icon, contentDescription = null) },
                    label = {
                        Text(
                                text = item.label,
                                fontFamily = FontFamily.SansSerif
                        )
                    }
            )
        }
    }
}