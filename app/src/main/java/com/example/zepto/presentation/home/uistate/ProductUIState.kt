package com.example.zepto.presentation.home.uistate

import com.example.zepto.data.model.GroceryProducts

data class ProductUIState(
        val isLoading: Boolean = false,
        val success: GroceryProducts? = null,
        val failure: String? = null
)
