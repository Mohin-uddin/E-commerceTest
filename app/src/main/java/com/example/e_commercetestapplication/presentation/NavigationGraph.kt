package com.example.e_commercetestapplication.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_commercetestapplication.presentation.ui.MainViewModel
import com.example.e_commercetestapplication.presentation.ui.screen.CartScreen
import com.example.e_commercetestapplication.presentation.ui.screen.HomePage
import com.example.e_commercetestapplication.presentation.ui.screen.productDetailScreen

@Composable
fun NavigationGraph(
    navController :NavHostController
) {
    val viewModel: MainViewModel = hiltViewModel()
    NavHost(
    navController = navController,
    startDestination = AllScreenRote.Home.route
    ) {
        composable(route = AllScreenRote.Home.route) {
            HomePage(navController,viewModel)
        }
        composable(route = AllScreenRote.ProductDetails.route) {
            productDetailScreen(viewModel = viewModel) {
                navController.popBackStack()
            }
        }
        composable(route = AllScreenRote.CartList.route) {
            CartScreen(viewModel = viewModel) {
                navController.popBackStack()
            }
        }


    }
}