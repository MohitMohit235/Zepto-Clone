
package com.example.zepto.presentation.orders

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.data.model.orderlist

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState")
@Composable
fun OrderItems(
        navController: NavController,
        onBackMainClick: () -> Unit,
) {
    
    val font = FontFamily(Font(R.font.mainfonts))
    
    val orderList = listOf(
           
            orderlist(
                    orderId = "#00003",
                    itemsName = "Cooking Oil, Flour",
                    totalAmount = "520",
                    tracking = "Packing"
            )
    )
    
    Scaffold(
            
            topBar = {
                TopAppBar(
                        navigationIcon = {
                            IconButton(
                                    onClick = {
                                        onBackMainClick()
                                    }
                            ) {
                                Icon(
                                        imageVector = Icons.Outlined.ArrowBack,
                                        contentDescription = null,
                                        tint = Color.Black
                                )
                            }
                        },
                        title = {
                            Text(
                                    text = "My Order",
                                    fontFamily = font
                            )
                        }
                )
            },
    ) { paddingValues ->
        
        LazyColumn(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(orderList) { orders ->
            
            }
        }
    }
}