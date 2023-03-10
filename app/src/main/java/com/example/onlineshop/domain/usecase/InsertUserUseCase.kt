package com.example.onlineshop.domain.usecase

import com.example.onlineshop.domain.models.User
import com.example.onlineshop.domain.repository.Repository

class InsertUserUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(user : User){
        return repository.insertUser( user )
    }
}