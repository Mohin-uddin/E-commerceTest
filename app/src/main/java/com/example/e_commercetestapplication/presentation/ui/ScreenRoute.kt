package com.example.e_commercetestapplication.presentation.ui

sealed class ScreenRoute(val route: String){
    object SplashScreen : ScreenRoute("splash_screen")
    object MainScreen : ScreenRoute("main_screen")
    object ProductDetailsScreen : ScreenRoute("product_details_screen")
    object CartScreen : ScreenRoute("cart_screen")
}
