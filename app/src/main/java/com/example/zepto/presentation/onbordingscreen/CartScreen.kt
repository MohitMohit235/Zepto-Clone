package com.example.zepto.presentation.onbordingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.data.model.productitems

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
        navController: NavController,
        OnBackMainClick: () -> Unit,
) {
    val cartItems = mutableStateListOf<productitems>()
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    LazyColumn(
            modifier = Modifier
                    .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            if (cartItems.size == 0) {
                Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                ) {
                    Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        
                        Image(
                                painter = painterResource(R.drawable.emptycart),
                                contentDescription = null,
                                modifier = Modifier.size(180.dp)
                        )
                        
                        Text(
                                text = "Your cart is empty",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = font,
                        )
                        
                        Spacer(modifier = Modifier.height(20.dp))
                        
                        Button(
                                shape = MaterialTheme.shapes.medium,
                                colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF673AB7)
                                ),
                                onClick = { OnBackMainClick() }
                        ) {
                            Text(
                                    text = "Add products to continue",
                                    fontFamily = font,
                                    fontSize = 12.sp
                            )
                        }
                    }
                    Button(
                            enabled = false,
                            modifier = Modifier
                                    .fillMaxWidth(fraction = 0.8f)
                                    .padding(top = 600.dp),
                            onClick = {},
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = if (cartItems.size == 0) Color.DarkGray.copy(
                                            alpha = 0.4f
                                    ) else Color(
                                            0xFF17923D
                                    )
                            )
                    ) {
                        Text(
                                text = "CheckOut Now",
                                fontFamily = font
                        )
                    }
                }
            } else {
                LazyColumn(
                        modifier = Modifier.fillMaxSize()
                ) {
                    item {
                    
                    }
                }
            }
        }
    }
}