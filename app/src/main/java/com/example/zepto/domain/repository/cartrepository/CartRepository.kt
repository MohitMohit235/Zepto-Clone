package com.example.zepto.domain.repository.cartrepository

import com.example.zepto.data.model.CartItems
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun addToCart(cart: CartItems)
    
    suspend fun getCartItems(): Flow<List<CartItems>>
    
    suspend fun removeFromCart(cart: CartItems)
    
    suspend fun updateCart(cart: CartItems)
    
    suspend fun getCartItem(productId: Int): CartItems?
    
    suspend fun clearCart()

}