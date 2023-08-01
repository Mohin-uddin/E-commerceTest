package com.example.e_commercetestapplication.domain.repository


import com.example.e_commercetestapplication.data.remote.ProductItem
import kotlinx.coroutines.flow.Flow


interface ProductLocalDatabaseRepository {
    fun getAllCartProduct(): Flow<List<ProductItem>>
    suspend fun insertProduct(productItem: ProductItem)
}