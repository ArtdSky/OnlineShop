package com.example.onlineshop.presentation.models

data class FlashSale (
    val category : String,
    val name : String,
    val price : Double,
    val discount : Double,
    val image_url : String,
        )