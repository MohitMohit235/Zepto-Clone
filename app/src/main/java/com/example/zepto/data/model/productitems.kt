package com.example.zepto.data.model

import androidx.compose.ui.graphics.painter.Painter

data class productitems(
        val productName: String? = null,
        val productImage: Painter,
        val productQuantity: String? = null,
        val productPrice: String? = null,
        val productTime: String? = null
)
