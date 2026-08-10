package com.example.zepto.data.repositoryimpl.cartrepositoryimpl

import com.example.zepto.data.model.CartItems
import com.example.zepto.di.cartdao.CartDao
import com.example.zepto.domain.repository.cartrepository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
): CartRepository{
    override suspend fun addToCart(cart: CartItems) {
    cartDao.insert(cart)
    }
    
    override suspend fun getCartItems(): Flow<List<CartItems>> {
        return cartDao.getCartItems()
    }
    
    override suspend fun removeFromCart(cart: CartItems) {
        cartDao.delete(cart)
    }
    
    override suspend fun updateCart(cart: CartItems) {
        cartDao.update(cart)
    }
    
    override suspend fun getCartItem(productId: Int): CartItems? {
        return cartDao.getCartItem(id = productId)
    }
    
    override suspend fun clearCart() {
    cartDao.clearCart()
    }
}