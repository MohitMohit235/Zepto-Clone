package com.example.zepto.presentation.navigation

sealed class Screen(val route: String) {
    object CartScreen : Screen(route = "cart_screen")
    object MainScreen : Screen(route = "main_screen")
    object CheckOutScreen : Screen(route = "checkout_screen")
    
    object AddressScreen : Screen(route = "address_screen")
    object AddressAddScreen : Screen(route = "addressAdd_screen")
    
    object AddressEditScreen : Screen(route = "addressEdit_screen")
}