package com.example.zepto.presentation.orders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zepto.R
import com.example.zepto.data.model.orderlist


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderItemList(order: orderlist) {
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val trackingColor = getTrackingColor(order.tracking)
    
    val trackingStep = when (order.tracking) {
        "Order Placed" -> 1
        "Confirmed" -> 2
        "Packing" -> 3
        "Out for Delivery" -> 4
        "Delivered" -> 5
        else -> 0
    }
    
    ElevatedCard(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
            )
    ) {
        
        Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            
            Row(){
                Text(
                        text = "HTTEWPWER",
                        fontFamily = font,
                        color = Color.Black,
                        fontSize = 8.sp
                )
            }
            
            Card(
                    modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp),
                    colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF3F3F3)
                    )
            ) {
                
                Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                ) {
                    
                    Image(
                            painter = painterResource(R.drawable.map),
                            contentDescription = "Map",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                    )
                    
                    Card(
                            modifier = Modifier.padding(12.dp),
                            colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                            )
                    ) {
                        
                        Row(
                                modifier = Modifier.padding(
                                        horizontal = 12.dp,
                                        vertical = 8.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            
                            Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = Color.Red
                            )
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            Text(
                                    text = "Arriving in 12 mins",
                                    fontFamily = font,
                                    color = Color.Black
                            )
                        }
                    }
                }
            }
            
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                
                Text(
                        text = order.itemsName,
                        fontFamily = font
                )
                
                Text(
                        text = "₹${order.totalAmount}",
                        fontFamily = font
                )
            }
            
            Row(
                    verticalAlignment = Alignment.CenterVertically
            ) {
                
                Text(
                        text = order.tracking,
                        fontFamily = font,
                        color = trackingColor
                )
                
                Spacer(modifier = Modifier.width(6.dp))
                
                Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = trackingColor
                )
            }
            
            OrderTrackingProgress(
                    currentStep = trackingStep
            )
            
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                
                Text(
                        text = "Placed",
                        fontFamily = font,
                        fontSize = 10.sp
                )
                
                Text(
                        text = "Confirmed",
                        fontFamily = font,
                        fontSize = 10.sp
                )
                
                Text(
                        text = "Packing",
                        fontFamily = font,
                        fontSize = 10.sp
                )
                
                Text(
                        text = "Out",
                        fontFamily = font,
                        fontSize = 10.sp
                )
                
                Text(
                        text = "Done",
                        fontFamily = font,
                        fontSize = 10.sp
                )
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