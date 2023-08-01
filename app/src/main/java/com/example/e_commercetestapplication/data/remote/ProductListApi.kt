package com.example.e_commercetestapplication.data.remote

import retrofit2.http.GET

interface ProductListApi {
    @GET("/products")
    suspend fun getProductData(): ProductListResponse
}