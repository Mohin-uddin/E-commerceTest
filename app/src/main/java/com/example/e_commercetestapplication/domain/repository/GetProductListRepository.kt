package com.example.e_commercetestapplication.domain.repository

import com.example.e_commercetestapplication.data.remote.ProductListResponse
import com.example.e_commercetestapplication.domain.util.Resource

interface GetProductListRepository {
    suspend fun getProductData(): Resource<ProductListResponse>
}