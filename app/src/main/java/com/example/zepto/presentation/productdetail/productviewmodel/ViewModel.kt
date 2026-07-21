package com.example.zepto.presentation.productdetail.productviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zepto.data.model.Product
import com.example.zepto.data.repositoryimpl.productroomrepoiml.ProductRoomRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
        private val repository: ProductRoomRepositoryImpl,
): ViewModel(){
    
    private val _product = MutableStateFlow<Product?>(null)
    val product = _product.asStateFlow()
    
    fun getProductById(id: Int){
        viewModelScope.launch {
            repository.productById(id).collect {
                _product.value = it
            }
        }
    }
}