package com.example.zepto.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
        @PrimaryKey
        val id: Int,
        
        val category: String,
        val description: String,
        val thumbnail : String,
        val price: Double,
        val rating: Double,
        val title: String,
)