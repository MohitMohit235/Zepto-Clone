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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.zepto.R
import com.example.zepto.data.model.Product
import com.example.zepto.presentation.carts.cartviewmodel.CartViewModel

@Composable
fun ProductCard(
        product: Product,
        onProductScreen: () -> Unit,
        onAddClick: () -> Unit,
        productViewModel : CartViewModel = hiltViewModel()
) {
    val font = FontFamily(Font(R.font.mainfonts))
    val accentPurple = Color(0xFFF85B4F)
    val cartItems by productViewModel.cartItems.collectAsState()
    val cartItem = cartItems.find { it.productId == product.id }
    
    
    Card(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(255.dp)
                    .clickable { onProductScreen() },
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Box(
                    modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
            ) {
                
                AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                        contentScale = ContentScale.Fit
                )
                
                if (cartItem == null) {
                    
                    Box(
                            modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(width = 55.dp, height = 32.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .border(1.dp, accentPurple, RoundedCornerShape(8.dp))
                                    .background(Color.White)
                                    .clickable {
                                        productViewModel.addCart(product)
                                    },
                            contentAlignment = Alignment.Center
                    ) {
                        Text(
                                text = "ADD",
                                color = accentPurple,
                                fontWeight = FontWeight.Bold
                        )
                    }
                    
                } else {
                    
                    Row(
                            modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(accentPurple)
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                    ) {
                        
                        Text(
                                "-",
                                color = Color.White,
                                modifier = Modifier.clickable {
                                    productViewModel.decreaseQuantity(product)
                                }
                        )
                        
                        Spacer(modifier = Modifier.width(8.dp))
                        
                        Text(
                                "${cartItem.quantity}",
                                color = Color.White
                        )
                        
                        Spacer(modifier = Modifier.width(8.dp))
                        
                        Text(
                                "+",
                                color = Color.White,
                                modifier = Modifier.clickable {
                                    productViewModel.increaseQuantity(product)
                                }
                        )
                    }
                }
            }
            Row(
                    verticalAlignment = Alignment.CenterVertically
            ) {
                
                Box(
                        modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF2E7D32))
                ) {
                    
                    Text(
                            text = "₹${product.price}",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = font,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(6.dp))
                
                Text(
                        text = "₹${product.originalPrice}",
                        color = Color.Gray,
                        fontFamily = font,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.LineThrough
                )
            }
            Text(
                    text = "${product.discountPercent}% OFF",
                    color = Color.Red,
                    fontFamily = font,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
            )
            Text(
                    text = product.name ?: "",
                    maxLines = 2,
                    fontFamily = font,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp
            )
            Text(
                    text = "${product.quantity}",
                    fontFamily = font,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                            .padding(6.dp)
            
            )
        }
    }
    
}