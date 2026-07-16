package com.example.zepto.presentation.drawer.address.addressScreens

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zepto.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressTopBar(
        navController: NavController,
        onBackClick:()-> Unit,
        OnAddClick:()-> Unit
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
            ),
            title = {
                Text(
                        text = "My Addresses",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = font,
                        fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent
                        ),
                        onClick = {onBackClick()}
                ) {
                    Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(25.dp),
                            tint = Color.Black
                    )
                }
            },
            actions = {
                IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Transparent
                        ),
                        onClick = {OnAddClick()}
                ) {
                    Icon(
                            imageVector = Icons.Outlined.Add,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            tint = Color(0xFF673AB7)
                    )
                }
            }
    )
}