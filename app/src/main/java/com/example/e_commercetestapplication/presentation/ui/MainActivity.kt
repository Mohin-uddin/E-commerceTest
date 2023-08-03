package com.example.e_commercetestapplication.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commercetestapplication.presentation.AllScreenRote
import com.example.e_commercetestapplication.presentation.NavigationGraph
import com.example.e_commercetestapplication.presentation.theme.ECommerceTestApplicationTheme
import com.example.e_commercetestapplication.presentation.ui.screen.CartScreen
import com.example.e_commercetestapplication.presentation.ui.screen.HomePage
import com.example.e_commercetestapplication.presentation.ui.screen.productDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            var navController: NavHostController = rememberNavController()
            ECommerceTestApplicationTheme {
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
        }
    }
}

