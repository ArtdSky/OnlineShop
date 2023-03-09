package com.example.onlineshop.data.network

import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import com.example.onlineshop.data.network.models.ResponseWrapper
import com.example.onlineshop.data.storage.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiStorage() : Storage {
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

}
