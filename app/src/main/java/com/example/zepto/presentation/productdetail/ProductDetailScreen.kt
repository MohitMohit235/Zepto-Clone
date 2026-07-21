package com.example.zepto.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
            modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp)
                        .padding(horizontal = 20.dp)
                        .padding(paddingValues),
                verticalArrangement = Arrangement.Top
        ) {
            item {
                product?.let {
                    Box(){
                        Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                    onClick = { OnBackClick() }
                            ) {
                                Icon(
                                        imageVector = Icons.Filled.ArrowBackIos,
                                        contentDescription = null
                                )
                            }
                            Box(
                                    modifier = Modifier
                                            .clip(shape = CircleShape)
                                            .background(color = Color(0x68191919)),
                                    contentAlignment = Alignment.Center
                            ) {
                                IconButton(
                                        onClick = { OnBackClick() }
                                ) {
                                    Icon(
                                            imageVector = Icons.Filled.FavoriteBorder,
                                            contentDescription = null,
                                            tint = Color.White
                                    )
                                }
                            }
                        }
                        AsyncImage(
                                model = it.thumbnail,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 50.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                    ) {
                        
                        Box(
                                modifier = Modifier
                                        .clip(shape = MaterialTheme.shapes.medium)
                                        .background(color = Color(0x8E7838EA))
                                        .padding(4.dp),
                                contentAlignment = Alignment.Center
                        ) {
                            Text(
                                    modifier = Modifier.padding(horizontal = 10.dp),
                                    text = it.category,
                                    fontFamily = font,
                                    fontSize = 14.sp,
                                    color = Color.White
                            )
                        }
                        
                        Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFE0AF15)
                            )
                            
                            Text(
                                    modifier = Modifier
                                            .padding(start = 10.dp)
                                            .padding(2.dp),
                                    text = "${it.rating}",
                                    fontFamily = font,
                                    color = Color.Black,
                                    fontSize = 20.sp
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                                text = it.title,
                                fontFamily = font,
                                color = Color.Black,
                                fontSize = 16.sp,
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                            text = "₹${(it.price * Constants.PRICE_MULTIPLIER).roundToInt()}",
                            fontFamily = font,
                            color = Color(0xFF4B4B4B),
                            fontSize = 20.sp
                    )
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(
                            text = "${it.description}",
                            fontFamily = font,
                            color = Color.Black,
                            fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(110.dp))
                    
                    Button(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7)),
                            onClick = {}
                    ) {
                        Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = null
                        )
                        
                        Spacer(modifier = Modifier.width(10.dp))
                        
                        Text(
                                text = "add to cart",
                                fontFamily = font
                        )
                    }
                    
                }
            }
        }
    }
}