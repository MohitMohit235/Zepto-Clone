package com.example.zepto.presentation.navigation

sealed class Screen(val route: String) {
    object CartScreen : Screen(route = "cart_screen")
    object MainScreen : Screen(route = "main_screen")
    object CheckOutScreen : Screen(route = "checkout_screen")
    
    object AddressScreen : Screen(route = "address_screen")
    object AddressAddScreen : Screen("addressAdd_screen/{id}") {
        fun createRoute(id: Int): String {
            return "addressAdd_screen/$id"
        }
    }
    
    object ProductDetailScreen : Screen(route = "product_screen/{productId}"){
        fun createRoute(productId: Int) = "product_screen/$productId"
    }
    
    object SplashScreen : Screen(route = "splash_screen")
}