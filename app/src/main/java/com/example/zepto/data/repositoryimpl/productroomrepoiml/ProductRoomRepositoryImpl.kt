package com.example.zepto.data.repositoryimpl.productroomrepoiml

import com.example.zepto.data.model.Product
import com.example.zepto.data.remote.ApiService
import com.example.zepto.di.productdao.ProductDao
import com.example.zepto.domain.repository.productrepo.productroomrepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRoomRepositoryImpl @Inject constructor(
        private val apiService: ApiService,
        private val productDao: ProductDao,
) : productroomrepo {
    override fun getProducts(): Flow<List<Product>> {
        return productDao.products()
    }
    
    override suspend fun refreshProducts() {
        val response = apiService.getGroceryProduct()
        productDao.insertProducts(response.products)
    }
    
    override suspend fun productById(id : Int): Flow<Product?> {
       return productDao.getProductById(id)
    }
    
}