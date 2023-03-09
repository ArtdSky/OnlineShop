package com.example.onlineshop.presentation.state

import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.Latest

data class ViewState (
    val flashSales : List<FlashSale> = emptyList(),
    val latest : List<Latest> = emptyList()
        )