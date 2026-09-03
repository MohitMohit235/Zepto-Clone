package com.example.zepto.presentation.onbordingscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zepto.presentation.carts.cartScreens.CartScreen
import com.example.zepto.presentation.category.CategoryItems
import com.example.zepto.presentation.drawer.address.viewmodel.AddressViewModel
import com.example.zepto.presentation.home.componet.DrawerContent
import com.example.zepto.presentation.home.componet.HomeBottomBar
import com.example.zepto.presentation.home.componet.HomeItems
import com.example.zepto.presentation.home.componet.HomeTopBar
import com.example.zepto.presentation.navigation.Screen
import com.example.zepto.presentation.orders.OrderItems
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainZeptoScreen(
        viewModel: AddressViewModel = hiltViewModel(),
        navController: NavController,
        onAddress: () -> Unit,
        OnCartClick: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val bottomNavController = rememberNavController()
    val addressList by viewModel.getallAdd.collectAsState(initial = emptyList())
    val address = addressList.firstOrNull()
    Scaffold(
            containerColor = Color.White,
            modifier = Modifier
                    .fillMaxSize(),
            contentWindowInsets = WindowInsets(0),
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
                        navController,
                        onAddress = { onAddress() }
                )
            }
            
            composable("categories") {
                CategoryItems(
                        navController = bottomNavController,
                        onBackMainClick = {
                            bottomNavController.navigate("home") {
                                popUpTo("cart") { inclusive = true }
                            }
                        }
                )
            }
            
            composable("orders") {
                OrderItems(
                        navController = bottomNavController,
                        onBackMainClick = {
                            bottomNavController.navigate("home") {
                                popUpTo("cart") { inclusive = true }
                            }
                        }
                )
            }
            composable("cart") {
                CartScreen(
                        navController = bottomNavController,
                        onBackMainClick = {
                            bottomNavController.navigate("home") {
                                popUpTo("cart") { inclusive = true }
                            }
                        },
                        onPaymentSCreenClick = {
                            navController.navigate(Screen.PaymentScreen.route){
                                popUpTo(Screen.CartScreen.route){inclusive = true}
                            }
                        }
                )
            }
        }
    }
}