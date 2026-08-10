package com.example.zepto.di.cartdao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.zepto.data.model.CartItems
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cart: CartItems)
    
    @Query("SELECT * FROM cart")
    fun getCartItems(): Flow<List<CartItems>>

    @Query("SELECT * FROM cart WHERE productId = :id")
    suspend fun getCartItem(id: Int): CartItems?
    
    @Query("DELETE FROM cart")
    suspend fun clearCart()
    
    @Update
    suspend fun update(cart: CartItems)
    
    @Delete
    suspend fun delete(cart: CartItems)
    
    
}