package com.example.onlineshop.presentation.utils

import androidx.core.util.PatternsCompat

fun isValidEmail(email: String): Boolean {
    val matcher = PatternsCompat.EMAIL_ADDRESS.matcher(email)
    return matcher.matches()
}