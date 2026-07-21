package com.example.zepto.domain.repository.productrepo

import com.example.zepto.data.model.Product
import kotlinx.coroutines.flow.Flow

interface productroomrepo {
    
    fun getProducts(): Flow<List<Product>>
    
    suspend fun refreshProducts()
    
    suspend fun productById(productId: Int): Flow<Product?>
    
    
}