package com.example.onlineshop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onlineshop.presentation.screens.Login
import com.example.onlineshop.presentation.screens.Page1
import com.example.onlineshop.presentation.screens.Profile
import com.example.onlineshop.presentation.screens.SignInPage
import com.example.onlineshop.presentation.viewmodel.MainViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
    ) {

    NavHost(
        navController = navController,
        startDestination = SignInPageScreen.route,

    ) {
        composable(route = SignInPageScreen.route) {
            SignInPage(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = LoginScreen.route) {
            Login(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = ProfileScreen.route) {
            Profile(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = Page1Screen.route) {
            Page1(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

    }

}

