package com.example.onlineshop.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest
import com.example.onlineshop.domain.models.User
import com.example.onlineshop.domain.usecase.GetFlashSalesUseCase
import com.example.onlineshop.domain.usecase.GetLatestUseCase
import com.example.onlineshop.domain.usecase.GetUserByNameUseCase
import com.example.onlineshop.domain.usecase.InsertUserUseCase
import com.example.onlineshop.presentation.state.ViewState
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getFlashSalesUseCase: GetFlashSalesUseCase,
    private val getLatestUseCase: GetLatestUseCase,
    private val getUserByNameUseCase: GetUserByNameUseCase,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {
    init {
    }

    private val _viewState = MutableStateFlow(
        ViewState()
    )
    val viewState = _viewState.asStateFlow()


    fun loadData() {
        viewModelScope.launch {

            val flashSales = getFlashSalesUseCase()
            val latest = getLatestUseCase()

            _viewState.update { currentState ->
                currentState.copy(
                    flashSales = flashSales,
                    latest = latest,
                )
            }
        }
    }

    fun signIn() {
        viewModelScope.launch {
            insertUserUseCase(
                User(
                    first_name = "Test",
                    last_name = "Qwest",
                    email = "test@mail"
                )
            )
        }
    }

        fun logIn(name : String) {
        viewModelScope.launch {
            val result = getUserByNameUseCase(
                name = name
            )
            if(result == null){
                _viewState.update { currentState ->
                    currentState.copy(
                        isLogged = false,
                    )
                }
                Log.d("TAG-VM","FAIL, USER IS NOT FOUND")
            } else {
                _viewState.update { currentState ->
                    currentState.copy(
                        isLogged = true,
                    )
                }
                Log.d("TAG-VM","SUCCESS LOGIN")
            }
        }
    }



}


