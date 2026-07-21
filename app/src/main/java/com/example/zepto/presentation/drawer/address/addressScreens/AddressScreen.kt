package com.example.zepto.presentation.drawer.address.addressScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.presentation.drawer.address.commpn.AddressSaveCard
import com.example.zepto.presentation.drawer.address.viewmodel.AddressViewModel
import com.example.zepto.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun AddressScreen(
        navController: NavController,
        onBackClick: () -> Unit,
        OnAddClick: () -> Unit,
        viewModel: AddressViewModel = hiltViewModel(),
) {
    val addressList by viewModel.getallAdd.collectAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.collectAsState()
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    val snackbarHostState = remember { SnackbarHostState() }
    val scop = rememberCoroutineScope()
    
    Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AddressTopBar(
                        navController = navController,
                        onBackClick = { onBackClick() },
                        OnAddClick = { OnAddClick() }
                )
            },
            snackbarHost = {
                SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier
                )
            }
    ) { paddingValues ->
        when {
            isLoading -> {
                Box(
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                        contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            
            addressList.isEmpty() -> {
                Column(
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 80.dp)
                                .padding(paddingValues),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                            painter = painterResource(R.drawable.noaddress),
                            contentDescription = null,
                            modifier = Modifier.size(370.dp),
                            contentScale = ContentScale.Fit
                    )
                    
                    Text(
                            text = "No addresses saved yet",
                            fontFamily = font,
                            fontSize = 20.sp,
                            color = Color.Black
                    )
                    
                    Text(
                            text = "Add your delivery address to place\norders faster.",
                            fontFamily = font,
                            lineHeight = 18.sp,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                    )
                }
            }
            
            else -> {
                LazyColumn(
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                                .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(addressList) { items ->
                        AddressSaveCard(
                                navController = navController,
                                address = items,
                                onUpdateClick = {
                                    navController.navigate("addressAdd_screen/${items.id}")
                                },
                                onDeleteClick = {
                                    viewModel.deleteAddress(items)
                                    scop.launch {
                                        val result = snackbarHostState.showSnackbar(
                                                message = "Address deleted successfully",
                                                actionLabel = "Undo",
                                                duration = SnackbarDuration.Long
                                        )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            viewModel.addAddress(items)
                                        }
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}

