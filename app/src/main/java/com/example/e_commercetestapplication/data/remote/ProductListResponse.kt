package com.example.e_commercetestapplication.data.remote

import com.squareup.moshi.Json

data class ProductListResponse(
    @field:Json(name = "products")
    val productList: List<ProductItem>
    )
