package com.example.zepto.presentation.home.componet.tabbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zepto.R

@Composable
fun CategoryTabBar(
        categories: List<CategoryModel>,
        selectedCategory: CategoryModel,
        onCategorySelected: (CategoryModel) -> Unit,
) {
    val font = FontFamily(Font(R.font.lexendexa_regular))
    val accentPurple = Color(0xFF663AB6)
    val accentPurpleLight = Color(0xFFE9E7E7)
    
    LazyRow(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            val isSelected = category.name == selectedCategory.name
            
            Box(
                    modifier = Modifier
                            .clickable { onCategorySelected(category) }
            
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                            model = category.imageUrl,
                            contentDescription = category.name,
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.Fit
                    )
                    Text(
                            text = category.name,
                            fontFamily = font,
                            fontSize = 10.sp,
                            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                            color = if (isSelected) Color.Black else Color.Black
                    )
                    Box(
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(if (isSelected) Color.Black else Color.Transparent)
                                    .padding(horizontal = 18.dp, vertical = 6.dp),
                            contentAlignment = Alignment.CenterVertically.let { Alignment.Center }
                    ) {
                    
                    }
                }
            }
        }
    }
}