package com.example.zepto.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zepto.R

@Composable
fun ProductInfoCards() {
    Surface(
            modifier = Modifier
                    .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 2.dp
    ) {
        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InfoCardItem(
                    icon = Icons.Filled.Block,
                    label = "No Return or Exchange",
                    modifier = Modifier.weight(1f)
            )
            InfoCardItem(
                    icon = Icons.Filled.FlashOn,
                    label = "Fast Delivery",
                    modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InfoCardItem(
        icon: androidx.compose.ui.graphics.vector.ImageVector,
        label: String,
        modifier: Modifier = Modifier
) {
    
    val font = FontFamily(Font(R.font.mainfonts))
    
    Column(
            modifier = modifier
                    .background(
                            color = Color(0xFFEEEEFC),
                            shape = RoundedCornerShape(12.dp)
                    )
                    .padding(vertical = 10.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
                modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent),
                contentAlignment = Alignment.Center
        ) {
            Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = Color(0xFF2E2E3A),
                    modifier = Modifier.size(25.dp)
            )
        }
        Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1C1C28),
                fontFamily = font,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}