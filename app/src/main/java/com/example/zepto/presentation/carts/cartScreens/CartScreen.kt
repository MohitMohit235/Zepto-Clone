package com.example.zepto.presentation.carts.cartScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.zepto.R
import com.example.zepto.data.model.productitems
import com.example.zepto.presentation.carts.cartviewmodel.CartViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
        navController: NavController,
        onBackMainClick: () -> Unit,
        cartViewModel: CartViewModel = hiltViewModel(),
) {
    
    val cartItems by cartViewModel.cartItems.collectAsState()
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val totalAmount = cartItems.sumOf { item ->
        item.price * item.quantity
    }
    
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
                                    text = "Cart",
                                    fontFamily = font
                            )
                        }
                )
            },
            bottomBar = {
                Button(
                        onClick = {
                            navController.navigate("payment/${totalAmount.toInt()}")
                        },
                        enabled = cartItems.isNotEmpty(),
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                                containerColor = if (cartItems.isEmpty())
                                    Color.Gray
                                else
                                    Color(0xFF17923D)
                        ),
                        shape = MaterialTheme.shapes.medium
                ) {
                    
                    Text(
                            text = "Checkout Now • ₹${totalAmount.toInt()}",
                            fontFamily = font
                    )
                }
                
            }
    
    ) { paddingValues ->
        
        if (cartItems.isEmpty()) {
            
            Box(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    
                    contentAlignment = Alignment.Center
            ) {
                
                Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(paddingValues)
                ) {
                    
                    Image(
                            painter = painterResource(R.drawable.emptycart),
                            contentDescription = null,
                            modifier = Modifier.size(180.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    Text(
                            text = "Your cart is empty",
                            fontFamily = font,
                            fontSize = 18.sp
                    )
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(
                            text = "Looks like you haven't added anything yet.",
                            textAlign = TextAlign.Center,
                            fontFamily = font
                    )
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    Button(
                            onClick = {
                                onBackMainClick()
                            },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF673AB7)
                            )
                    ) {
                        
                        Text(
                                text = "Add products",
                                fontFamily = font
                        )
                        
                    }
                    
                }
                
            }
            
        } else {
            
            LazyColumn(
                    
                    modifier = Modifier
                            .padding(paddingValues)
                            .padding(top = 10.dp)
                            .padding(horizontal = 10.dp)
                            .clip(shape = MaterialTheme.shapes.small)
                            .background(color = Color.White)
            
            
            ) {
                
                items(cartItems) { item ->
                    
                    Card(
                            colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                            ),
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                            vertical = 6.dp
                                    )
                    ) {
                        
                        Row(
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            
                            AsyncImage(
                                    model = item.image,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                            )
                            
                            Spacer(modifier = Modifier.width(12.dp))
                            
                            Column(
                                    modifier = Modifier.weight(1f)
                            ) {
                                
                                Text(
                                        text = item.title,
                                        fontFamily = font,
                                        fontSize = 10.sp
                                )
                                
                                Spacer(modifier = Modifier.height(5.dp))
                                
                                Text(
                                        text = "${item.quantity} Pack",
                                        color = Color.DarkGray,
                                        fontFamily = font,
                                        fontSize = 10.sp
                                )
                                
                            }
                            Column(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.End
                            ) {
                                Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                                .clip(shape = RoundedCornerShape(6.dp))
                                                .background(color = Color(0xFFF85B4F))
                                ) {
                                    TextButton(
                                            onClick = {
                                                cartViewModel.decreaseCartItemQuantity(item)
                                            },
                                            modifier = Modifier.size(20.dp),
                                            contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Text("-", color = Color.White)
                                    }
                                    
                                    Text(
                                            text = "${item.quantity}",
                                            modifier = Modifier.padding(horizontal = 12.dp),
                                            fontFamily = font,
                                            color = Color.White
                                    )
                                    
                                    TextButton(
                                            onClick = {
                                                cartViewModel.increaseCartItemQuantity(item)
                                            },
                                            modifier = Modifier.size(20.dp),
                                            contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Text("+", color = Color.White)
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                
                                Text(
                                        text = "₹${item.price}",
                                        color = Color(0xFF17913D),
                                        fontFamily = font,
                                        fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}