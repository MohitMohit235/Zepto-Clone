package com.example.zepto.presentation.drawer.address.addressScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zepto.R

data class addAddressElements(
        val lable: String? = null,
        val leadIcon: ImageVector? = null,
        val placeholder: String? = null
)



@Composable
fun AddressDetailField(
        label: String? = null,
        leadIcon: ImageVector? = null,
        placeholder: String? = null,
        value: String,
        onValueChange:(String) -> Unit
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        label?.let {
            Text(
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = font,
            )
        }
        OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = {newValue->
                    onValueChange(newValue)
                },
                leadingIcon = leadIcon?.let { icon ->
                    {
                        Box(
                                modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color.LightGray.copy(alpha = 0.4f))
                                        .size(30.dp),
                                contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = Color(0xFF4711A7)
                            )
                        }
                    }
                },
                placeholder = {
                    placeholder?.let {
                        Text(
                                text = it,
                                color = Color.Black.copy(alpha = 0.5f),
                                fontFamily = font,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 12.sp
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Gray.copy(alpha = 0.3f),
                        focusedBorderColor =  Color(0xFF9863F5)
                )
        )
    }
}