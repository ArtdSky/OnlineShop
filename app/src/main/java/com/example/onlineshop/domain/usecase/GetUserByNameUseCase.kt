package com.example.onlineshop.domain.usecase

import com.example.onlineshop.domain.models.User
import com.example.onlineshop.domain.repository.Repository

class GetUserByNameUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(name : String) : User?{
        return repository.getByName(name)
    }
}