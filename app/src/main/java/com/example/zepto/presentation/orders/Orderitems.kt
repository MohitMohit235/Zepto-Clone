
package com.example.zepto.presentation.orders

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zepto.data.model.orderlist

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState")
@Composable
fun OrderItems(
        navController: NavController
) {
    
    val orderList = listOf(
            orderlist(
                    orderId = "#00001",
                    itemsName = "Milk, Bread, Eggs",
                    totalAmount = "320",
                    tracking = "Delivered"
            ),
            orderlist(
                    orderId = "#00002",
                    itemsName = "Rice, Sugar",
                    totalAmount = "450",
                    tracking = "Confirmed"
            ),
            
            orderlist(
                    orderId = "#00003",
                    itemsName = "Cooking Oil, Flour",
                    totalAmount = "520",
                    tracking = "Packing"
            ),
            
            orderlist(
                    orderId = "#00004",
                    itemsName = "Apple, Banana, Orange",
                    totalAmount = "380",
                    tracking = "Out for Delivery"
            ),
            
            orderlist(
                    orderId = "#00005",
                    itemsName = "Vegetables, Fruits",
                    totalAmount = "600",
                    tracking = "Delivered"
            )
    )
    
    LazyColumn(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(orderList) { orders ->
            OrderItemList(order = orders)
        }
    }
}