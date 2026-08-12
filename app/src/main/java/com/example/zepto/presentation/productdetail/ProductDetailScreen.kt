package com.example.zepto.presentation.productdetail

import android.view.Surface
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.zepto.Constants
import com.example.zepto.R
import com.example.zepto.presentation.productdetail.productviewmodel.ProductDetailViewModel
import java.util.Locale
import java.util.Locale.getDefault
import kotlin.math.roundToInt
import kotlin.text.toDoubleOrNull
import kotlin.time.toDuration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
        productId: Int,
        viewModel: ProductDetailViewModel = hiltViewModel(),
        navController: NavController,
        OnBackClick: () -> Unit,
) {
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    val product by viewModel.product.collectAsState()
    
    LaunchedEffect(productId) {
        viewModel.getProductById(productId)
    }
    
    Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0),
            bottomBar = {
                
                Surface(
                        shadowElevation = 10.dp,
                        color = Color.White
                ) {
                    Row(
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 18.dp, vertical = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp),
                                onClick = {
                                
                                },
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE91E63)
                                )
                        ) {
                            Text(
                                    text = "Add to Cart",
                                    fontFamily = font
                            )
                        }
                    }
                }
            }
    ) { paddingValues ->
        LazyColumn(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp, top = 40.dp)
                        .padding(horizontal = 20.dp)
                        .padding(paddingValues),
                verticalArrangement = Arrangement.Top
        ) {
            item {
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                            modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .size(40.dp)
                                    .background(color = Color(0x4D313131)),
                            contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                                onClick = { OnBackClick() }
                        ) {
                            Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(6.dp)
                            )
                        }
                    }
                    Box(
                            modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .size(40.dp)
                                    .background(color = Color(0x4D313131)),
                            contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                                onClick = { OnBackClick() }
                        ) {
                            Icon(
                                    imageVector = Icons.Filled.FavoriteBorder,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(6.dp)
                            )
                        }
                    }
                }
            }
            item {
                product?.let {
                    Box(){
                        AsyncImage(
                                model = it.image,
                                contentDescription = null,
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .height(350.dp),
                                contentScale = ContentScale.Fit
                        )
                    }
                    
                    Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(Color(0xFFEEEEFC))
                            
                    ) {
                        
                        Column(
                                modifier = Modifier.padding(16.dp)
                        ){
                            
                            Card(
                                    colors = CardDefaults.cardColors(Color(0xFFE9E9E9))
                            ) {
                                
                                Row(
                                        Modifier.padding(3.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                ) {
                                    
                                    Icon(
                                            painterResource(R.drawable.lightning),
                                            null,
                                            tint = Color(0xFF6A1B9A),
                                            modifier = Modifier.size(10.dp)
                                    )
                                    
                                    Spacer(Modifier.width(2.dp))
                                    
                                    Text(
                                            it.deliveryTime,
                                            fontFamily = font,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold
                                    )
                                    
                                    
                                }
                                
                            }
                            
                            Text(
                                    text = it.name,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = font
                            )
                            
                            Text(
                                    text = "Net quantity: (${it.quantity})",
                                    color = Color.DarkGray,
                                    fontSize = 12.sp,
                                    fontFamily = font
                            )
                            
                            Box(
                                    modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color(0xFF2B9533))
                            ) {
                                
                                Row(
                                        Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                            "₹${it.price}",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = font,
                                            color = Color.White
                                    )
                                }
                            }
                            Row(
                                    verticalAlignment = Alignment.CenterVertically
                            ) {
                                
                                Text(
                                        "MRP ",
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = font,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                )
                                
                                Text(
                                        "₹${it.originalPrice}",
                                        textDecoration = TextDecoration.LineThrough,
                                        color = Color.Gray,
                                        fontSize = 12.sp,
                                        fontFamily = font
                                )
                                
                                Text(
                                        " (incl. of all taxes)",
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = font,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                )
                                
                                Spacer(Modifier.width(8.dp))
                                
                                Text(
                                        "${it.discountPercent}% OFF",
                                        color = Color(0xFF2E7D32),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = font
                                )
                                
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    ProductInfoCards()
                }
            }
        }
    }
}