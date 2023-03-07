package com.example.onlineshop.presentation.navigation

interface AppDestination {
    val route : String
}

object LoginScreen : AppDestination{
    override val route = "login"
}

object SignInPageScreen : AppDestination{
    override val route = "signin"
}

object ProfileScreen : AppDestination{
    override val route = "profile"
}

object Page1Screen : AppDestination{
    override val route = "page1"
}

val AppTabRowScreens = listOf(LoginScreen, SignInPageScreen, ProfileScreen, Page1Screen)