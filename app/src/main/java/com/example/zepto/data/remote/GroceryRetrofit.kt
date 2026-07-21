package com.example.zepto.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GroceryRetrofit {
    
    private const val BASE_URL_KEY = "https://dummyjson.com/"
    
    @Provides
    @Singleton
    fun api(): ApiService{
        return Retrofit.Builder()
                .baseUrl(BASE_URL_KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
    
}