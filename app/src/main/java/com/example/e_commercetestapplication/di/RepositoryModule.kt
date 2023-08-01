package com.example.e_commercetestapplication.di

import com.example.e_commercetestapplication.data.reprository.GetProductListRepositoryImp
import com.example.e_commercetestapplication.domain.repository.GetProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGetProductRepository(
        productListRepositoryImp: GetProductListRepositoryImp
    ): GetProductListRepository
}