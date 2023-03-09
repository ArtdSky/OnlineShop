package com.example.onlineshop.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest
import com.example.onlineshop.domain.usecase.GetFlashSalesUseCase
import com.example.onlineshop.domain.usecase.GetLatestUseCase
import com.example.onlineshop.presentation.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getFlashSalesUseCase: GetFlashSalesUseCase,
    private val getLatestUseCase: GetLatestUseCase
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
            Log.d("VM-latest", "$latest")
                _viewState.update { currentState ->
                    currentState.copy(
                        flashSales = flashSales,
                        latest = latest,
                    )
                }
        }
    }
}


