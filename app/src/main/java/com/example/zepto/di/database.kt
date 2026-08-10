package com.example.zepto.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zepto.data.model.Address
import com.example.zepto.data.model.CartItems
import com.example.zepto.data.model.Product
import com.example.zepto.di.addressdao.AddressDao
import com.example.zepto.di.cartdao.CartDao
import com.example.zepto.di.productdao.ProductDao


@Database(
        entities = [
            Address::class,
            Product::class,
            CartItems::class
        ],
        version = 12,
        exportSchema = false
)
abstract class database : RoomDatabase() {
    abstract fun addressDao(): AddressDao
    
    abstract fun productDao(): ProductDao
    
    abstract fun cartDao() : CartDao
    
}