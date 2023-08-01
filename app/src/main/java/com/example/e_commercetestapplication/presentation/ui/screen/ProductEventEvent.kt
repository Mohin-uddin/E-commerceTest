package com.example.e_commercetestapplication.presentation.ui.screen

import com.example.e_commercetestapplication.data.remote.ProductItem

sealed class ProductEventEvent {
    class SelectedProduct(val productItem: ProductItem) : ProductEventEvent()
    class Failure(val error: String) : ProductEventEvent()
    object Empty : ProductEventEvent()
}