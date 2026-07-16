package com.example.zepto.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class bottomNavItem(
        val route: String,
        val icon: ImageVector,
        val label: String,
){
    object Home : bottomNavItem(
            "home",
            Icons.Outlined.Home,
            "Home"
    )
    
    object Categories : bottomNavItem(
            "categories",
            Icons.Outlined.Category,
            "Categories"
    )
    
    object Order : bottomNavItem(
            "orders",
            Icons.Outlined.ShoppingBag,
            "Orders"
    )
    
    object Cart : bottomNavItem(
            "cart",
            Icons.Outlined.ShoppingCart,
            "Cart"
    )
    
}
