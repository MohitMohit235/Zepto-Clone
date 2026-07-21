package com.example.zepto.data.remote

import androidx.room.Query
import com.example.zepto.data.model.GroceryProducts
import com.example.zepto.data.model.Product
import com.example.zepto.data.model.productitems
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("products")
    suspend fun getGroceryProduct(): GroceryProducts
    
    @POST("id")
    suspend fun getProductById(): Product
    
}