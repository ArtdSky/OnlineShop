package com.example.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.onlineshop.presentation.screens.SignInPage
import com.example.onlineshop.ui.theme.OnlineShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShopTheme {
                // A surface container using the 'background' color from the theme
                SignInPage()
            }
        }
    }
}

