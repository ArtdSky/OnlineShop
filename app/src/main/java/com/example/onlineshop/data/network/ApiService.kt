package com.example.onlineshop.data.network

import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSales(): FlashSaleData

    @GET("/v1/public/characters")
    suspend fun getLatestSales(): Result<LatestData>


}