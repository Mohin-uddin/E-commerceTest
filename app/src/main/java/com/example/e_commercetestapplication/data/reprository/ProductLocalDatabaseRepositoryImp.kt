package com.example.e_commercetestapplication.data.reprository

import com.example.e_commercetestapplication.data.data_source.ProductDao
import com.example.e_commercetestapplication.data.remote.ProductItem
import com.example.e_commercetestapplication.domain.repository.ProductLocalDatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductLocalDatabaseRepositoryImp @Inject constructor(
    private val dao: ProductDao
) : ProductLocalDatabaseRepository {
    override fun getAllCartProduct(): Flow<List<ProductItem>> {
        return dao.getAllProduct()
    }

    override suspend fun insertProduct(productItem: ProductItem) {
        return dao.insertProductItem(productItem = productItem)
    }

}