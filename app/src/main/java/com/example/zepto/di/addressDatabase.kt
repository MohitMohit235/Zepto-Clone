package com.example.zepto.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zepto.data.model.Product
import com.example.zepto.di.addressdao.AddressDao
import com.example.zepto.di.productdao.ProductDao


@Database(
        entities = [
            Address::class,
            Product::class
        ],
        version = 2,
        exportSchema = false
)
abstract class addressDatabase : RoomDatabase() {
    abstract fun addressDao(): AddressDao
    
    abstract fun productDao(): ProductDao
}