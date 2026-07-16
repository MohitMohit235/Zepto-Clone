package com.example.zepto.di

import android.content.Context
import androidx.room.Room
import com.example.zepto.data.repositoryimpl.Repository

object Graph {
    lateinit var database: addressDatabase
    
    val addressRepository by lazy {
        Repository(dao = database.addressDao())
    }
    
    fun provider(context: Context){
        database = Room.databaseBuilder(context, addressDatabase::class.java,"address.db").build()
    }
    
}
