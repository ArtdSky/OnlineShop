package com.example.onlineshop.domain.usecase

import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.repository.Repository

class GetFlashSalesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<FlashSale> {
        return repository.getFlashSales()
    }


}