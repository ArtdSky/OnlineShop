package com.example.onlineshop.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.onlineshop.data.local.models.UserEntity
import com.example.onlineshop.data.network.models.FlashSaleData
import com.example.onlineshop.data.network.models.LatestData
import com.example.onlineshop.data.network.models.ResponseWrapper
import com.example.onlineshop.data.storage.Storage
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest
import com.example.onlineshop.domain.models.User
import com.example.onlineshop.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val storage: Storage
) : Repository {
    override suspend fun getFlashSales(): List<FlashSale> = withContext(Dispatchers.IO) {
        val flashSaleList = mutableListOf<FlashSale>()
        when (val flashSalesData = storage.getFlashSalesData().single()) {
            is ResponseWrapper.Success -> {
                val resultList = mapFlashSalesToDomain(flashSalesData.value)
                flashSaleList.addAll(resultList)
            }
            is ResponseWrapper.NetworkError -> try {
                Log.d("NO NETWORK", "NO NETWORK FOR LOAD flashSalesData")
            } catch (e: Throwable) {
                Log.d("NETWORK ERROR", "${e.message}")
            }
            is ResponseWrapper.GenericError -> try {
                Log.d("GENERIC DATA", "${flashSalesData.code}")
            } catch (e: Throwable) {
                Log.d("GENERIC ERROR", "${e.message}")
            }
        }
        flashSaleList
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getLatest(): List<Latest> = withContext(Dispatchers.IO) {
        val latestList = mutableListOf<Latest>()
        when (val latestData = storage.getLatestData().single()) {
            is ResponseWrapper.Success -> {
                val resultList = mapLatestToDomain(latestData.value)
                latestList.addAll(resultList)
            }
            is ResponseWrapper.NetworkError -> try {
                Log.d("NO NETWORK", "NO NETWORK FOR LOAD latestData: $latestList ")
            } catch (e: Throwable) {
                Log.d("NETWORK ERROR", "${e.message}")
            }
            is ResponseWrapper.GenericError -> try {
                Log.d("GENERIC DATA", "${latestData.code}")
            } catch (e: Throwable) {
                Log.d("GENERIC ERROR", "${e.message}")
            }
        }
        latestList
    }

    override suspend fun insertUser(user: User) {
        val userEntity = mapUserToStorage(user)
        storage.insertUser(userEntity)
    }

    override suspend fun getByName(name: String): User? {
        val result = storage.getByName(name).map {
                mapUserEntityToDomain(it)
            }
        if (result == emptyList<User>()){
            return null
        }
        return result[0]
    }


    private fun mapFlashSalesToDomain(flashSalesData: FlashSaleData): List<FlashSale> {
        val listFlashSales: MutableList<FlashSale> = mutableListOf()
        flashSalesData.flashSale.forEach { flashSale ->
            val flashSales = FlashSale(
                flashSale.category,
                flashSale.name,
                flashSale.price,
                flashSale.discount?.toDouble(),
                flashSale.imageUrl
            )
            listFlashSales.add(flashSales)
        }
        return listFlashSales
    }

    private fun mapLatestToDomain(latestData: LatestData): List<Latest> {
        val listLatest: MutableList<Latest> = mutableListOf()
        latestData.latest.forEach { last ->
            val latest = Latest(
                last.category,
                last.name,
                last.price?.toDouble(),
                last.imageUrl
            )
            listLatest.add(latest)
        }
        return listLatest
    }

    private fun mapUserToStorage(user: User): UserEntity {
        return UserEntity(
            first_name = user.first_name,
            last_name = user.last_name,
            email = user.email
        )
    }

    private fun mapUserEntityToDomain(user: UserEntity): User {
        return User(
            first_name = user.first_name,
            last_name = user.last_name,
            email = user.email
        )
    }
}