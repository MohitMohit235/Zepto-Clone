package com.example.zepto.di

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {
    @Insert
    suspend fun insert(address: Address)
    
    @Update
    suspend fun update(address: Address)
    
    @Delete
    suspend fun delete(address: Address)
    
    @Query("SELECT * FROM address")
    fun getAddresses(): Flow<List<Address>>
    
    @Query("SELECT * FROM address WHERE id= :id")
    fun getAddressById(id: Int): Flow<Address?>
    
    @Query("SELECT*FROM address WHERE addressType = 'Current Location'LIMIT 1")
    suspend fun getCurrentLocation(): Address?
}