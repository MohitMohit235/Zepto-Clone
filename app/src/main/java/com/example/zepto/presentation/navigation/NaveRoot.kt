package com.example.zepto.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zepto.presentation.drawer.address.addressScreens.AddressAddScreen
import com.example.zepto.presentation.drawer.address.addressScreens.AddressScreen
import com.example.zepto.presentation.onbordingscreen.CheckOutScreen
import com.example.zepto.presentation.onbordingscreen.MainZeptoScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NaveRoot() {
    val navController = rememberNavController()
    NavHost(
            navController = navController,
            startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainZeptoScreen(
                    navController,
                    OnCartClick = {
                        navController.navigate(Screen.CartScreen.route) {
                            popUpTo(Screen.MainScreen.route) { inclusive = true }
                        }
                    }
            )
        }
        composable(route = Screen.CheckOutScreen.route) {
            CheckOutScreen(navController)
        }
        
        composable(
                route = Screen.AddressScreen.route,
                enterTransition = {
                    slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right
                    )
                }
        ) {
            AddressScreen(
                    navController,
                    onBackClick = {
                        navController.navigate(Screen.MainScreen.route) {
                            popUpTo(Screen.AddressScreen.route) { inclusive = true }
                        }
                    },
                    OnAddClick = {
                        navController.navigate("addressAdd_screen/-1") {
                            popUpTo(Screen.AddressScreen.route) { inclusive = true }
                        }
                    },
            )
        }
        
        composable(
                route = "addressAdd_screen/{id}",
                arguments = listOf(
                        navArgument("id"){
                            type = NavType.IntType
                        }
                ),
                enterTransition = {
                    slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right
                    )
                }
        ) { backStackEntry->
            val id = backStackEntry.arguments?.getInt("id") ?:-1
            AddressAddScreen(
                    navController = navController,
                    addressId = id,
                    onBackClick = {
                        navController.navigate(Screen.AddressScreen.route) {
                            popUpTo(Screen.AddressAddScreen.route) { inclusive = true }
                        }
                    },
                    onAddressShowClick = {
                        navController.navigate(Screen.AddressScreen.route) {
                            popUpTo(Screen.AddressScreen.route) { inclusive = true }
                        }
                    },
                    
                    )
        }
        
    }
}