package com.example.zepto.data.repositoryimpl.productroomrepoiml

import com.example.zepto.data.model.Product
import com.example.zepto.di.productdao.ProductDao
import com.example.zepto.domain.repository.productrepo.productroomrepo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRoomRepositoryImpl @Inject constructor(
        private val firestore: FirebaseFirestore,
        private val productDao: ProductDao,
) : productroomrepo {
    override fun getProducts(): Flow<List<Product>> {
        return productDao.products()
    }
    
    override suspend fun refreshProducts() {
        
        val snapshot = firestore
                .collection("products")
                .get()
                .await()
        
        val product = snapshot.toObjects(Product::class.java)
        productDao.insertProducts(product)
    }
    
    override suspend fun productById(id: Int): Flow<Product?> {
        return productDao.getProductById(id)
    }
}