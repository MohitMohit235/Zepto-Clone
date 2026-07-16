package com.example.zepto.presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowRight
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zepto.R

@Composable
fun DrawerContent(
        onItemClick: (String) -> Unit,
        onClose: () -> Unit,
        onAddressClick: () -> Unit,
) {
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    val items = listOf(
            menuitems(
                    icon = Icons.Outlined.Person,
                    label = "Profile",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.Notifications,
                    label = "Notifications",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.CreditCard,
                    label = "Payment Methods",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.LocationOn,
                    label = "Addresses",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.Security,
                    label = "Privacy & Security",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.Help,
                    label = "Help & Support",
                    secondryLabel = null
            ),
            menuitems(
                    icon = Icons.Outlined.Info,
                    label = "About",
                    secondryLabel = null
            )
    )
    
    
    ModalDrawerSheet(
            drawerContainerColor = MaterialTheme.colorScheme.background
    ) {
        Text(
                "Setting",
                fontFamily = font,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
        )
        
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 30.dp)
        ) {
            Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                        modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape)
                                .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                ) {
                    Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                    )
                }
                
                Column {
                    Text(
                            text = "Mohit prajapati",
                            fontFamily = font,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                    )
                    Text(
                            text = "Mohitxxxxxpati@gmail.com",
                            fontFamily = font,
                            fontSize = 10.sp,
                            color = Color.Black
                    )
                }
            }
            Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
            )
        }
        
        items.forEach { item ->
            NavigationDrawerItem(
                    modifier = Modifier.height(70.dp),
                    label = {
                        Text(
                                item.label,
                                fontFamily = font,
                                color = Color.Black
                        )
                    },
                    selected = false,
                    onClick = {
                        if (item.label == "Addresses") {
                            onAddressClick()
                        } else {
                            onItemClick(item.label)
                        }
                        onClose()
                    },
                    icon = { Icon(item.icon, contentDescription = null) },
                    badge = {
                        Icon(
                                imageVector = Icons.Outlined.KeyboardArrowRight,
                                contentDescription = null
                        )
                    }
            )
        }
        
        TextButton(
                onClick = {},
                modifier = Modifier
        ) {
            Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                
                Icon(
                        imageVector = Icons.Outlined.ExitToApp,
                        contentDescription = null,
                        tint = Color(0xFFFF483A)
                )
                
                Text(
                        text = "Logout",
                        color = Color(0xFFFF483A),
                        fontSize = 15.sp,
                        fontFamily = font
                
                )
            }
        }
        
    }
}

data class menuitems(
        val icon: ImageVector,
        val label: String,
        val secondryLabel: String?,
)