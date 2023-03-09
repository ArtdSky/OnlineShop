package com.example.onlineshop.domain.usecase

import com.example.onlineshop.domain.models.Latest
import com.example.onlineshop.domain.repository.Repository

class GetLatestUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Latest> {
        return repository.getLatest()
    }


}