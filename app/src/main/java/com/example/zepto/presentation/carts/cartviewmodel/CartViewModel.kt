package com.example.zepto.presentation.carts.cartviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zepto.data.model.CartItems
import com.example.zepto.data.model.Product
import com.example.zepto.domain.repository.cartrepository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
        private val cartRepository: CartRepository
): ViewModel(){
    
    private val _cartItems = MutableStateFlow<List<CartItems>>(emptyList())
    val cartItems = _cartItems.asStateFlow()
    
    init {
        observeCart()
    }
    
    fun addCart(product: Product) {
        viewModelScope.launch {
            
            val existingItem = cartRepository.getCartItem(product.id)
            
            if (existingItem == null) {
                
                cartRepository.addToCart(
                        CartItems(
                                productId = product.id,
                                title = product.name,
                                image = product.image,
                                price = product.price,
                                quantity = 1
                        )
                )
                
            } else {
                
                cartRepository.updateCart(
                        existingItem.copy(
                                quantity = existingItem.quantity + 1
                        )
                )
            }
        }
    }
    
    fun getCartItems(){
        viewModelScope.launch {
            cartRepository.getCartItems().collect{items->
                _cartItems.value = items
            }
        }
    }
    
    fun deleteCart(items: CartItems){
        viewModelScope.launch {
            cartRepository.removeFromCart(cart = items)
        }
    }
    
    private fun observeCart() {
        viewModelScope.launch {
            cartRepository.getCartItems().collect {
                _cartItems.value = it
            }
        }
    }
    
    
    fun increaseQuantity(product: Product) {
        addCart(product)
    }
    
    fun decreaseQuantity(product: Product) {
        viewModelScope.launch {
            
            val item = cartRepository.getCartItem(product.id) ?: return@launch
            
            if (item.quantity == 1) {
                cartRepository.removeFromCart(item)
            } else {
                cartRepository.updateCart(
                        item.copy(quantity = item.quantity - 1)
                )
            }
        }
    }
    
    fun increaseCartItemQuantity(item: CartItems) {
        viewModelScope.launch {
            
            cartRepository.updateCart(
                    item.copy(
                            quantity = item.quantity + 1
                    )
            )
        }
    }
    
    fun decreaseCartItemQuantity(item: CartItems) {
        viewModelScope.launch {
            
            if (item.quantity == 1) {
                cartRepository.removeFromCart(item)
            } else {
                cartRepository.updateCart(
                        item.copy(
                                quantity = item.quantity - 1
                        )
                )
            }
        }
    }
    
}