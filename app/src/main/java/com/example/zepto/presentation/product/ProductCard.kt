package com.example.zepto.presentation.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Timelapse
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zepto.R

@Composable
fun ProductCard(
        productName: String?,
        productImage: Painter,
        productQuantity: String?,
        productPrice: String?,
        productTime: String?,
) {
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    Column(
            modifier = Modifier
                    .padding(16.dp)
                    .height(250.dp)
    ) {
        Box(
                modifier = Modifier
                        .fillMaxHeight()
                        .shadow(elevation = 6.dp, shape = MaterialTheme.shapes.small)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(Color.White),
                contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                    modifier = Modifier
                            .fillMaxHeight()
                            .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
            ) {
                
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                            imageVector = Icons.Outlined.Timelapse,
                            contentDescription = "time",
                            tint = Color.Green
                    )
                    
                    Text(
                            text = "${productTime}",
                            fontFamily = font,
                    )
                    
                }
                
                Image(
                        painter = productImage,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                                .fillMaxWidth()
                                .size(80.dp)
                )
                
                Text(
                        text = "${productName}",
                        fontFamily = font,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                )
                
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    
                    Text(
                            text = "${productQuantity}",
                            fontFamily = font,
                            
                            )
                    Text(
                            text = "₹${productPrice}",
                            fontFamily = font,
                    
                    )
                }
                OutlinedButton(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier.fillMaxWidth(),
                        border = BorderStroke(width = 1.3.dp, color = Color.Red),
                        onClick = {}
                ) {
                    Text(
                            text = "Add to Cart",
                            color = Color.Red,
                            fontFamily = font,
                            fontSize = 12.sp
                    )
                }
            }
        }
    }
}