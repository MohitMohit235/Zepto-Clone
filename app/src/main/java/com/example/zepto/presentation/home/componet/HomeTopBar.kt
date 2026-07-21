package com.example.zepto.presentation.home.componet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zepto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
        navController: NavController,
        onAddressClick: () -> Unit,
        OnClickOpen: () -> Unit,
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                            Color(0xFFC0A0F9)
                    )
    ) {
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
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
                                .padding(top = 10.dp)
                                .clickable { onAddressClick() },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                            painter = painterResource(R.drawable.lightning),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                    .size(15.dp)
                                    .graphicsLayer(alpha = 0.99f)
                    
                    )
                    Text(
                            text = "5 minutes",
                            color = Color.Black,
                            fontFamily = font,
                            fontSize = 16.sp
                    )
                }
                
                Icon(
                        painter = painterResource(R.drawable.profile_circle),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                                .size(30.dp)
                                .clickable { OnClickOpen() }
                
                )
                
            }
            Box(
                    Modifier
                            .fillMaxWidth()
                            .height(80.dp)
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