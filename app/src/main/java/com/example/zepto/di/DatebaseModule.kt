package com.example.zepto.di


import android.content.Context
import androidx.room.Room
import com.example.zepto.di.addressdao.AddressDao
import com.example.zepto.di.cartdao.CartDao
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
    ): database {
        return Room.databaseBuilder(
                context,
                database::class.java,
                "address_database"
        )
                .fallbackToDestructiveMigration()
                .build()
    }
    
    @Provides
    fun provideAddressDao(
            database: database
    ): AddressDao {
        return database.addressDao()
    }
    
    @Provides
    fun provideProductDao(
            database: database
    ): ProductDao {
        return database.productDao()
    }
    
    @Provides
    fun provideCartDao(
            database: database
    ): CartDao{
        return database.cartDao()
    }
    
    
}