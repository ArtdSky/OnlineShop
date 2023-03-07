package com.example.onlineshop.presentation.di

import com.example.onlineshop.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module{

    factory {  }

    viewModel { MainViewModel() }


}