package com.example.zepto.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.presentation.drawer.address.viewmodel.AddressViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
        navController: NavController,
        viewModel: AddressViewModel = hiltViewModel(),
        OnClickOpen: () -> Unit,
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    var searchBar by remember { mutableStateOf(false) }
    
    
    
    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                            Color(0xFF673AB7)
                    )
    ) {
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
        ) {
            Row(
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, start = 10.dp)
                            .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                        modifier = Modifier
                                .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                    .size(30.dp)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        val gradient = Brush.verticalGradient(
                                                colors = listOf(
                                                        Color(0xFF95267C),
                                                        Color(0xFFD7176C),
                                                )
                                        )
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(
                                                    brush = gradient,
                                                    blendMode = BlendMode.SrcAtop
                                            )
                                        }
                                    }
                    )
                    Text(
                            text = "Home",
                            color = Color.White,
                            fontFamily = font,
                            fontSize = 20.sp
                    )
                    
                    Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = "cart icon",
                            tint = Color(0xFFCF366A),
                            modifier = Modifier
                                    .size(30.dp)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        val gradient = Brush.verticalGradient(
                                                colors = listOf(
                                                        Color(0xFF95267C),
                                                        Color(0xFFD7176C),
                                                )
                                        )
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(
                                                    brush = gradient,
                                                    blendMode = BlendMode.SrcAtop
                                            )
                                        }
                                    }
                    )
                }
                
                Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    OnClickOpen()
                                    Log.d("Drawer", "Icon Clicked")
                                    
                                }
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    val gradient = Brush.verticalGradient(
                                            colors = listOf(
                                                    Color(0xFF95267C),
                                                    Color(0xFFD7176C),
                                            )
                                    )
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(
                                                brush = gradient,
                                                blendMode = BlendMode.SrcAtop
                                        )
                                    }
                                }
                )
            }
            Box(
                    Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .padding(14.dp)
                            .clip(shape = MaterialTheme.shapes.medium)
                            .background(Color.White),
                    contentAlignment = Alignment.CenterStart
            ) {
                Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                    )
                    Text(
                            text = "Search",
                            fontSize = 18.sp
                    )
                }
            }
        }
    }
}