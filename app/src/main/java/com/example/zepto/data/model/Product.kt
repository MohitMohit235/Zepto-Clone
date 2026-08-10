package com.example.zepto.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
        
        @PrimaryKey
        val id: Int = 0,
        
        val name: String = "",
        val image: String = "",
        val category: String = "",
        val quantity: String = "",
        
        val price: Int = 0,
        val originalPrice: Int = 0,
        
        val discountPercent: Int = 0,
        
        val deliveryTime: String = "5 mins",
        
        val rating: Double = 0.0,
        val ratingCount: Int = 0,
        
        val isBestSeller: Boolean = false,
        val inStock: Boolean = true
)