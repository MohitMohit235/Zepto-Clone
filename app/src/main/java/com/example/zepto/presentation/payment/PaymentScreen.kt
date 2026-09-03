package com.example.zepto.presentation.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.presentation.carts.cartviewmodel.CartViewModel
import com.example.zepto.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
        navController: NavController,
        OnBackCartClick: () -> Unit,
        cartViewModel: CartViewModel = hiltViewModel(),
) {
    
    val cartItems by cartViewModel.cartItems.collectAsState()
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val totalAmount = cartItems.sumOf { item ->
        item.price * item.quantity
    }
    
    val images = listOf(
            painterResource(R.drawable.imagepay1),
            painterResource(R.drawable.imagepay2),
            painterResource(R.drawable.imagepay3),
            painterResource(R.drawable.imagepay4),
    )
    
    Scaffold(
            
            topBar = {
                TopAppBar(
                        modifier = Modifier.shadow(elevation = 3.dp),
                        title = {
                            Column(
                                    modifier = Modifier.padding(vertical = 10.dp)
                            ) {
                                Text(
                                        text = "Payment Options",
                                        fontFamily = font,
                                        fontSize = 18.sp
                                )
                                Text(
                                        text = "To Pay : ₹${totalAmount.toInt()}",
                                        fontFamily = font,
                                        fontSize = 12.sp
                                )
                            }
                        }
                )
            },
            bottomBar = {
                Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF098765)),
                        onClick = {},
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp)
                                .padding(16.dp)
                                .height(55.dp),
                        shape = MaterialTheme.shapes.medium
                ) {
                    
                    Text(
                            text = "Pay now • ₹${totalAmount.toInt()}",
                            fontFamily = font
                    )
                }
                
            }
    
    ) { paddingValues ->
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                        .padding(paddingValues)
                        .padding(horizontal = 15.dp)
        ) {
            Column(
                    modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                        text = "Pay by any UPI app",
                        fontFamily = font,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                )
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    images.forEach { image ->
                        Image(
                                painter = image,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                        )
                    }
                }
                Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEDEDED))
                ) {
                    Text(
                            text = "+ Add new UPI Id",
                            fontFamily = font,
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                    )
                }
            }
            
            
            Column(
                    modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
            ) {
                Text(
                        text = "Cards",
                        fontFamily = font,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEDEDED))
                ) {
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Image(
                                painter = painterResource(R.drawable.card),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                        )
                        
                        Text(
                                text = "Credit/Debit Cards",
                                fontFamily = font,
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
            
            Column(
                    modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
            ) {
                Text(
                        text = "Cash",
                        fontFamily = font,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEDEDED))
                ) {
                    
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Text(
                                text = "Cash On Delivery (COD)",
                                fontFamily = font,
                                fontSize = 12.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}