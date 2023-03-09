package com.example.onlineshop.data.network

import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSales(): FlashSaleData

    @GET("/v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestSales(): LatestData


}