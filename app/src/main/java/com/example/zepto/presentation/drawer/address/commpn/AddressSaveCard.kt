package com.example.zepto.presentation.drawer.address.commpn

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.di.Address

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressSaveCard(
        navController: NavController,
        address: Address,
        onUpdateClick: () -> Unit,
        onDeleteClick: () -> Unit,
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val icon = if (address.addressType == "Home") painterResource(R.drawable.home) else painterResource(R.drawable.bag)
    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 4.dp, shape = MaterialTheme.shapes.large)
                    .clip(shape = MaterialTheme.shapes.large)
                    .background(color = Color.White)
                    .padding(horizontal = 12.dp),
    ) {
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
            ) {
                
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    
                    Icon(
                            painter = icon,
                            contentDescription = null,
                            tint = Color(0xFF7B7B7B)
                    )
                    
                    Text(
                            text = address.addressType,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            fontFamily = font
                    )
                    
                }
                
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                            onClick = { onUpdateClick() }
                    ) {
                        Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = null,
                                tint = Color.Gray
                        )
                    }
                    
                    IconButton(
                            onClick = { onDeleteClick() }
                    ) {
                        Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = null,
                                tint = Color.Gray
                        )
                    }
                    
                }
            }
            
            HorizontalDivider()
            Spacer(modifier = Modifier.height(10.dp))
            
            Text(
                    text = address.fullName,
                    fontFamily = font,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
            )
            
            Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                )
                
                Text(
                        text = address.phone,
                        fontFamily = font,
                        fontSize = 12.sp
                )
            }
            
            Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                )
                
                Text(
                        text = "${address.addressLine1}, ${address.addressLine2}, ${address.city}, ${address.state}, ${address.country} - ${address.pincode}",
                        maxLines = 4,
                        fontFamily = font,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 10.sp
                )
            }
        }
    }
}