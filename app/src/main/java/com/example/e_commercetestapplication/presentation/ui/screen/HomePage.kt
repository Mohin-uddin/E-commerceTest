package com.example.e_commercetestapplication.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.e_commercetestapplication.presentation.AllScreenRote
import com.example.e_commercetestapplication.presentation.ui.MainViewModel
import com.example.e_commercetestapplication.presentation.ui.componenet.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    viewModel.getAllCartList()
    Scaffold(
        modifier = Modifier
            .padding(start = 25.dp, top = 10.dp)
            .fillMaxWidth(),
        bottomBar = {
            AppBar(counter = viewModel.cartListLItem.collectAsState().value.size, onCartIconClick = {
                navHostController.navigate(AllScreenRote.CartList.route)
            } )
        }
    ) {
        val state =viewModel.state
        Box(modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.productList) { product ->
                    ProductItem(product = product ){
                        viewModel.selectMethod(product)
                        navHostController.navigate(AllScreenRote.ProductDetails.route)
                    }
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }


}