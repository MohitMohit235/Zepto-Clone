package com.example.zepto.presentation.drawer.address.commpn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zepto.R

@Composable
fun LocationSelectorChip(
        selectedLocation: String,
        onLocationSelected: (String) -> Unit
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
    ) {
        FilterChip(
                border = BorderStroke(
                        width = 1.5.dp,
                        color = if (selectedLocation == "Home") Color(0xFF9863F5) else Color.Black
                ),
                modifier = Modifier.height(55.dp),
                colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0x4ABF99FF),
                        selectedLabelColor = Color(0xFF9863F5),
                        labelColor = Color.Black
                ),
                selected = selectedLocation == "Home",
                onClick = {
                     onLocationSelected("Home")
                },
                leadingIcon = {
                    Icon(
                            painter = painterResource(R.drawable.home),
                            contentDescription = null,
                            modifier = Modifier
                                    .padding(start = 35.dp, end = 8.dp)
                                    .size(25.dp),
                            tint = if (selectedLocation == "Home") Color(0xFF9863F5) else Color.Black
                    )
                },
                label = {
                    Text(
                            text = "Home",
                            fontFamily = font,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 30.dp)
                    )
                }
        )
        
        Spacer(modifier = Modifier.width(28.dp))
        
        FilterChip(
                border = BorderStroke(
                        width = 1.5.dp,
                        color = if (selectedLocation == "Work") Color(0xFF9863F5) else Color.Black
                ),
                modifier = Modifier
                        .height(55.dp),
                colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0x4ABF99FF),
                        selectedLabelColor = Color(0xFF9863F5),
                        labelColor = Color.Black
                ),
                selected = selectedLocation == "Work",
                onClick = {
                    onLocationSelected("Work")
                },
                leadingIcon = {
                    Icon(
                            painter = painterResource(R.drawable.bag),
                            contentDescription = null,
                            modifier = Modifier
                                    .padding(start = 35.dp, end = 8.dp)
                                    .size(30.dp),
                            tint =  if (selectedLocation == "Work") Color(0xFF9863F5) else Color.Black
                    )
                },
                
                label = {
                    Text(
                            text = "Work",
                            fontFamily = font,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 30.dp)
                    )
                }
        )
        
    }
}