package com.example.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.onlineshop.presentation.navigation.NavState
import com.example.onlineshop.presentation.viewmodel.MainViewModel
import com.example.onlineshop.ui.theme.OnlineShopTheme
import org.koin.androidx.compose.koinViewModel

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
fun MainActivityScreen() {
    val myViewModel: MainViewModel = koinViewModel()
    NavState(vm = myViewModel)
}

