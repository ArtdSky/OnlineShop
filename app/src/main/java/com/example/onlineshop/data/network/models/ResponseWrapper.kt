package com.example.onlineshop.data.network.models

sealed class ResponseWrapper<out T> {

    data class Success<out T>(val value: T) : ResponseWrapper<T>()

    data class GenericError(val code: Int? = null) :
        ResponseWrapper<Nothing>()

    object NetworkError : ResponseWrapper<Nothing>()
}
