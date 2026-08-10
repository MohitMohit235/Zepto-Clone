package com.example.zepto.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zepto.data.model.CartItems
import com.example.zepto.data.model.GroceryProducts
import com.example.zepto.data.model.Product
import com.example.zepto.data.repositoryimpl.productroomrepoiml.ProductRoomRepositoryImpl
import com.example.zepto.domain.repository.cartrepository.CartRepository
import com.example.zepto.presentation.home.uistate.ProductUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
        private val productRoomViewModel: ProductRoomRepositoryImpl,
        private val cartRepository: CartRepository,
) : ViewModel() {
    
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()
    private val _Uistate = MutableStateFlow(ProductUIState())
    val uistate = _Uistate.asStateFlow()
    
    private val _cartItems = MutableStateFlow<List<CartItems>>(emptyList())
    
    val cartItems = _cartItems.asStateFlow()
    
    init {
        getGroceryProducts()
        refreshProducts()
    }
    
    fun getGroceryProducts() {
        viewModelScope.launch {
            _Uistate.value = ProductUIState(isLoading = true)
            
            productRoomViewModel.getProducts().collect { products ->
                _Uistate.value = ProductUIState(
                        isLoading = false,
                        success = GroceryProducts(
                                products = products,
                                total = products.size
                        )
                )
            }
        }
    }
    
    fun refreshProducts() {
        viewModelScope.launch {
            _isRefreshing.value = true
            
            try {
                productRoomViewModel.refreshProducts()
            } catch (e: Exception) {
            
            }
            
            _isRefreshing.value = false
        }
    }
    
   
    
}