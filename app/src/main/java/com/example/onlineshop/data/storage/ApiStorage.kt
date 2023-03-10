package com.example.onlineshop.data.storage

import com.example.onlineshop.data.local.UserRepository
import com.example.onlineshop.data.local.models.UserEntity
import com.example.onlineshop.data.network.Api
import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import com.example.onlineshop.data.network.models.ResponseWrapper
import com.example.onlineshop.data.network.safeApiCall
import com.example.onlineshop.data.storage.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiStorage(
    private val userRepository: UserRepository
) : Storage {
    override suspend fun getFlashSalesData(): Flow<ResponseWrapper<FlashSaleData>> {
        val res: Flow<ResponseWrapper<FlashSaleData>> = flow {
            val response = safeApiCall(Dispatchers.IO) {
                Api.retrofitApiService.getFlashSales()
            }
            emit(response)
        }
        return res
    }

    override suspend fun getLatestData(): Flow<ResponseWrapper<LatestData>> {
        val res: Flow<ResponseWrapper<LatestData>> = flow{
            val response = safeApiCall(Dispatchers.IO){
                Api.retrofitApiService.getLatestSales()
            }
            emit(response)
        }
        return res
    }

    override suspend fun insertUser(user: UserEntity) {
        return userRepository.insert(user)
    }

    override suspend fun getByName(name: String): List<UserEntity>{
        return userRepository.getByName(name)
    }

}
