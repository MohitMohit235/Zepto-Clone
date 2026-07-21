package com.example.zepto.di.productdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zepto.data.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun products(): Flow<List<Product>>
    
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertProducts(product: List<Product>)
    
    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): Flow<Product?>
}