package com.example.zepto.di

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val fullName: String,
        val phone: String,
        val addressLine1: String,
        val addressLine2: String,
        val city: String,
        val state: String,
        val country: String,
        val pincode: String,
        val addressType: String,
        val isDefault: Boolean = false,
)
