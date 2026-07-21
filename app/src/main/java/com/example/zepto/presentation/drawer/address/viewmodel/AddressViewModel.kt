package com.example.zepto.presentation.drawer.address.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zepto.di.Address
import com.example.zepto.data.repositoryimpl.roomdatabaserepoimpl.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
        private val repository: Repository,
) : ViewModel() {
    
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()
    
    val getallAdd = repository.getAllAddresses()
            .onEach {
                _isLoading.value = false
            }
    
    val getallAddress: Flow<List<Address>> =
        repository.getAllAddresses()
    
    fun addAddress(address: Address) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAddress(address = address)
            Log.d("ROOM", "Inserted: $address")
        }
    }
    
    fun updateAddress(address: Address) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAddress(address = address)
        }
    }
    
    fun deleteAddress(address: Address) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAddress(address = address)
        }
    }
    
    fun getAddressById(id: Int): Flow<Address?> {
        return repository.getAddressById(id = id)
    }
    
    fun saveCurrentLocation(address: Address){
        viewModelScope.launch(Dispatchers.IO){
            repository.getCurrentLocation(address)
        }
    }
    
}