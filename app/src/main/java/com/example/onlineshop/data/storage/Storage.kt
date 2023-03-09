package com.example.onlineshop.data.storage

import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import com.example.onlineshop.data.network.models.ResponseWrapper
import kotlinx.coroutines.flow.Flow

interface Storage {

    suspend fun getFlashSalesData(): Flow<ResponseWrapper<FlashSaleData>>

    suspend fun getLatestData(): Flow<ResponseWrapper<LatestData>>
}