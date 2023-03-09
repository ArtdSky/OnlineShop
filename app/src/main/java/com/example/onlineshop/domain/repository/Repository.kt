package com.example.onlineshop.domain.repository

import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest

interface Repository {

    suspend fun getFlashSales(): List<FlashSale>

    suspend fun getLatest(): List<Latest>

}