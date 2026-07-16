package com.example.zepto.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zepto.R
import com.example.zepto.data.model.productitems
import com.example.zepto.presentation.product.ProductCard

@Composable
fun HomeItems() {
    val product = listOf(
            productitems(
                    productName = "Britannia Brown Bread",
                    productImage = painterResource(R.drawable.image1),
                    productQuantity = "450 g",
                    productPrice = "50",
                    productTime = "12 min"
            ),
            productitems(
                    productName = "Tata Salt",
                    productImage = painterResource(R.drawable.image2),
                    productQuantity = "1 kg",
                    productPrice = "28",
                    productTime = "10 min"
            ),
            productitems(
                    productName = "Avocado",
                    productImage = painterResource(R.drawable.image3),
                    productQuantity = "500 g",
                    productPrice = "128",
                    productTime = "14 min"
            ),
            productitems(
                    productName = "Oranges",
                    productImage = painterResource(R.drawable.image4),
                    productQuantity = "1 kg",
                    productPrice = "95",
                    productTime = "8 min"
            ),
            productitems(
                    productName = "Britannia Brown Bread",
                    productImage = painterResource(R.drawable.image1),
                    productQuantity = "450 g",
                    productPrice = "50",
                    productTime = "12 min"
            ),
            productitems(
                    productName = "Tata Salt",
                    productImage = painterResource(R.drawable.image2),
                    productQuantity = "1 kg",
                    productPrice = "28",
                    productTime = "10 min"
            ),
            productitems(
                    productName = "Avocado",
                    productImage = painterResource(R.drawable.image3),
                    productQuantity = "500 g",
                    productPrice = "128",
                    productTime = "14 min"
            ),
            productitems(
                    productName = "Oranges",
                    productImage = painterResource(R.drawable.image4),
                    productQuantity = "1 kg",
                    productPrice = "95",
                    productTime = "8 min"
            )
    )
    LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        items(product) { items ->
            ProductCard(
                    productName = items.productName,
                    productImage = items.productImage,
                    productQuantity = items.productQuantity,
                    productPrice = items.productPrice,
                    productTime = items.productTime
            )
        }
    }
}