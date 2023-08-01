package com.example.e_commercetestapplication.data.reprository

import com.example.e_commercetestapplication.data.remote.ProductListApi
import com.example.e_commercetestapplication.data.remote.ProductListResponse
import com.example.e_commercetestapplication.domain.repository.GetProductListRepository
import com.example.e_commercetestapplication.domain.util.Resource
import javax.inject.Inject

class GetProductListRepositoryImp @Inject constructor(
    private val api: ProductListApi
): GetProductListRepository {
    override suspend fun getProductData(): Resource<ProductListResponse> {
        return try {
            Resource.Success(
                data = api.getProductData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}