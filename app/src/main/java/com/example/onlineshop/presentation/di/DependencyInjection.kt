package com.example.onlineshop.presentation.di

import com.example.onlineshop.data.local.UserDao
import com.example.onlineshop.data.local.UserRepository
import com.example.onlineshop.data.local.UsersDatabase
import com.example.onlineshop.data.repository.RepositoryImpl
import com.example.onlineshop.data.storage.ApiStorage
import com.example.onlineshop.data.storage.Storage
import com.example.onlineshop.domain.repository.Repository
import com.example.onlineshop.domain.usecase.GetFlashSalesUseCase
import com.example.onlineshop.domain.usecase.GetLatestUseCase
import com.example.onlineshop.domain.usecase.GetUserByNameUseCase
import com.example.onlineshop.domain.usecase.InsertUserUseCase
import com.example.onlineshop.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module {

    // Database
    single<UsersDatabase> {
        UsersDatabase.getDatabase(androidContext())
    }
    single<UserDao> {
        get<UsersDatabase>().userDao()
    }

    // Repository
    single {
        UserRepository(get())
    }
    single<Storage> {
        ApiStorage(get())
    }
    single<Repository> {
        RepositoryImpl(get())
    }

    // UseCase
    factory {
        GetFlashSalesUseCase(get())
    }
    factory {
        GetLatestUseCase(get())
    }
    factory { GetUserByNameUseCase(get()) }
    factory { InsertUserUseCase(get()) }

    // ViewModel
    viewModel { MainViewModel(get(), get(), get(), get()) }


}