package com.example.onlineshop.data.local

import com.example.onlineshop.data.local.models.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun getByName(name : String) : List<UserEntity> {
        return userDao.getByName(name)
    }


    suspend fun insert(user : UserEntity) {
        userDao.insert(user)
    }
}