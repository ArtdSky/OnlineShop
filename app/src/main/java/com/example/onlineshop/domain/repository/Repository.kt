package com.example.onlineshop.domain.repository

import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest
import com.example.onlineshop.domain.models.User
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getFlashSales(): List<FlashSale>

    suspend fun getLatest(): List<Latest>

    suspend fun getByName(name: String): User?

    suspend fun insertUser(user: User)

}