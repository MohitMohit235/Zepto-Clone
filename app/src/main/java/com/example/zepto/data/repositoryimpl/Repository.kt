package com.example.zepto.data.repositoryimpl

import com.example.zepto.di.Address
import com.example.zepto.di.AddressDao
import com.example.zepto.domain.repository.repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
        private val dao : AddressDao
): repository{
    override suspend fun addAddress(address: Address) {
        dao.insert(address)
    }
    
    override suspend fun updateAddress(address: Address) {
        dao.update(address)
    }
    
    override suspend fun deleteAddress(address: Address) {
       dao.delete(address)
    }
    
    override fun getAllAddresses(): Flow<List<Address>> {
      return  dao.getAddresses()
    }
    
    override fun getAddressById(id: Int): Flow<Address?> {
        return dao.getAddressById(id = id)
    }
    
    override suspend fun getCurrentLocation(address: Address) {
        val currentLocation = dao.getCurrentLocation()
        if (currentLocation == null){
            dao.insert(
                    address.copy(
                            addressType = "Current Location"
                    )
            )
        } else {
            dao.update(
                    currentLocation.copy(
                            fullName = address.fullName,
                            phone = address.phone,
                            addressLine1 = address.addressLine1,
                            addressLine2 = address.addressLine2,
                            city = address.city,
                            state = address.state,
                            country = address.country,
                            pincode = address.pincode
                    )
            )
        }
    }
}