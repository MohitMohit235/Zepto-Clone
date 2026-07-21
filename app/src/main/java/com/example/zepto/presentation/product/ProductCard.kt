package com.example.zepto.presentation.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zepto.Constants
import com.example.zepto.R
import kotlin.math.roundToInt
@Composable
fun ProductCard(
        onProductScreen:()-> Unit,
        productName: String?,
        productImage: String,
        productPrice: String?,
        productCategory: String?,
        productRating: Double?
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val accentPurple = Color(0xFFF85B4F)
    
    Column(
            modifier = Modifier
                    .padding(8.dp)
                    .width(170.dp)
                    .height(210.dp)
                    .clickable{
                        onProductScreen()
                    }
    ) {
        Box(
                modifier = Modifier
                        .fillMaxSize()
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(14.dp))
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .background(Color(0xFFF3F2F8))
                ) {
                    AsyncImage(
                            model = productImage,
                            contentDescription = productName,
                            modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(64.dp),
                            contentScale = ContentScale.Fit
                    )
                    
                    productCategory?.let {
                        Text(
                                text = it,
                                fontFamily = font,
                                fontSize = 10.sp,
                                color = Color(0xFF5F5E5A),
                                modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(6.dp)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color.White)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
                
                Column(
                        modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                            text = productName ?: "",
                            fontFamily = font,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.height(34.dp)
                    )
                    
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = Color(0xFFBA7517),
                                modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                                text = "${productRating ?: 0.0}",
                                fontFamily = font,
                                fontSize = 11.sp,
                                color = Color(0xFF5F5E5A)
                        )
                    }
                    
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                                text = "₹${((productPrice?.toDoubleOrNull() ?: 0.0) * Constants.PRICE_MULTIPLIER).roundToInt()}",
                                fontFamily = font,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                        )
                        
                        Box(
                                modifier = Modifier
                                        .border(width = 1.dp, color = accentPurple, shape = RoundedCornerShape(6.dp))
                        ) {
                            Text(
                                    text = "Add",
                                    color = accentPurple,
                                    fontFamily = font,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}