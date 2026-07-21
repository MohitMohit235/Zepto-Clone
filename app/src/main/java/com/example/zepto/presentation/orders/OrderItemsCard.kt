package com.example.zepto.presentation.orders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.zepto.R
import com.example.zepto.data.model.orderlist


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderItemList(order: orderlist) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val trackingColor = getTrackingColor(order.tracking)
    
    ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
            )
    ) {
        Column(
                modifier = Modifier
                        .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(order.itemsName, fontFamily = font)
                Text("₹${order.totalAmount}", fontFamily = font)
            }
            
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(order.tracking, fontFamily = font)
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = trackingColor
                    )
                   
                }
            }
        }
    }
}

fun getTrackingColor(status: String): Color {
    return when (status) {
        "Order Placed" -> Color(0xFF2196F3)
        "Confirmed" -> Color(0xFF3FAE45)
        "Packing" -> Color(0xFFFF9800)
        "Out for Delivery" -> Color(0xFFF44336)
        "Delivered" -> Color(0xFF266529)
        "Cancelled" -> Color(0xFFF44336)
        else -> Color.Gray
    }
}