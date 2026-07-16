package com.example.zepto.domain.repository

import com.example.zepto.di.Address
import kotlinx.coroutines.flow.Flow

interface repository {
    suspend fun addAddress(address: Address)
    
    suspend fun updateAddress(address: Address)
    
    suspend fun deleteAddress(address: Address)
    
    fun getAllAddresses(): Flow<List<Address>>
    
    fun getAddressById(id: Int): Flow<Address?>
    
    suspend fun getCurrentLocation(address: Address)
}