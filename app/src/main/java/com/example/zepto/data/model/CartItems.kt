package com.example.zepto.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartItems(
        
        @PrimaryKey
        val productId: Int,
        
        val title: String,
        
        val image: String,
        
        val price: Int,
        
        val quantity: Int = 1
)
