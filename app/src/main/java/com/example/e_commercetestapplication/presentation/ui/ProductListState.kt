package com.example.e_commercetestapplication.presentation.ui

import com.example.e_commercetestapplication.data.remote.ProductItem

data class ProductListState(
    val productList: List<ProductItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "null"
)
