package com.example.onlineshop.presentation.di

import com.example.onlineshop.data.network.ApiStorage
import com.example.onlineshop.data.repository.RepositoryImpl
import com.example.onlineshop.data.storage.Storage
import com.example.onlineshop.domain.repository.Repository
import com.example.onlineshop.domain.usecase.GetFlashSalesUseCase
import com.example.onlineshop.domain.usecase.GetLatestUseCase
import com.example.onlineshop.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module{

    single<Storage>{
        ApiStorage()
    }

    single<Repository>{
        RepositoryImpl(get())
    }

    factory{
        GetFlashSalesUseCase(get())
    }
    factory{
        GetLatestUseCase(get())
    }

    viewModel { MainViewModel(get(), get()) }


}