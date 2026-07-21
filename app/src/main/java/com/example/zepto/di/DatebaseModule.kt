package com.example.zepto.di


import android.content.Context
import androidx.room.Room
import com.example.zepto.di.addressdao.AddressDao
import com.example.zepto.di.productdao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(
            @ApplicationContext context: Context,
    ): addressDatabase {
        return Room.databaseBuilder(
                context,
                addressDatabase::class.java,
                "address_database"
        ).build()
    }
    
    @Provides
    fun provideAddressDao(
            database: addressDatabase
    ): AddressDao {
        return database.addressDao()
    }
    
    @Provides
    fun provideProductDao(
            database: addressDatabase
    ): ProductDao {
        return database.productDao()
    }
    
}