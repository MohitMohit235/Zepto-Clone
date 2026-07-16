package com.example.zepto.di

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
        entities = [Address::class],
        version = 1,
        exportSchema = false
)
 abstract class addressDatabase: RoomDatabase() {
    abstract fun addressDao(): AddressDao
}