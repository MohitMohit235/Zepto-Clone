package com.example.zepto.presentation.home.componet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.presentation.home.viewmodel.ProductViewModel

@Composable
fun HomeItems(
        navController: NavController,
        viewModel: ProductViewModel = hiltViewModel(),
        onAddress: () -> Unit,
) {
    val state by viewModel.uistate.collectAsState()
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
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                PullToRefreshBox(
                        state = pullToRefreshState,
                        isRefreshing = isRefreshing,
                        onRefresh = {
                            viewModel.refreshProducts()
                        }
                ) {
                    ProductList(
                            navController = navController,
                            onAddress = {onAddress()}
                            
                    )
                }
            }
        }
    }
}