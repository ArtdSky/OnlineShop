package com.example.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.onlineshop.presentation.navigation.NavState
import com.example.onlineshop.presentation.screens.Login
import com.example.onlineshop.presentation.screens.Page1
import com.example.onlineshop.presentation.screens.Profile
import com.example.onlineshop.ui.theme.OnlineShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShopTheme {
                MainActivityScreen()
            }
        }
    }
}



@Composable
fun MainActivityScreen(){
    NavState()
}

