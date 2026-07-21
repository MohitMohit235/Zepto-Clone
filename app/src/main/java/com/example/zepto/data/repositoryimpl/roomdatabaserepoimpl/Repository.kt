package com.example.zepto.data.repositoryimpl.roomdatabaserepoimpl

import com.example.zepto.data.model.Product
import com.example.zepto.di.Address
import com.example.zepto.di.addressdao.AddressDao
import com.example.zepto.domain.repository.roomdatabaserepo.repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
        private val addressDao : AddressDao
): repository {
    override suspend fun addAddress(address: Address) {
        addressDao.insert(address)
    }
    
    override suspend fun updateAddress(address: Address) {
        addressDao.update(address)
    }
    
    override suspend fun deleteAddress(address: Address) {
       addressDao.delete(address)
    }
    
    override fun getAllAddresses(): Flow<List<Address>> {
      return  addressDao.getAddresses()
    }
    
    override fun getAddressById(id: Int): Flow<Address?> {
        return addressDao.getAddressById(id = id)
    }
    
    override suspend fun getCurrentLocation(address: Address) {
        val currentLocation = addressDao.getCurrentLocation()
        if (currentLocation == null){
            addressDao.insert(
                    address.copy(
                            addressType = "Current Location"
                    )
            )
        } else {
            addressDao.update(
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