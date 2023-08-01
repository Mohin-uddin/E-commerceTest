package com.example.e_commercetestapplication.di

import android.app.Application
import androidx.room.Room
import com.example.e_commercetestapplication.data.data_source.ProductDatabase
import com.example.e_commercetestapplication.data.remote.ProductListApi
import com.example.e_commercetestapplication.data.reprository.ProductLocalDatabaseRepositoryImp
import com.example.e_commercetestapplication.domain.repository.ProductLocalDatabaseRepository
import com.example.e_commercetestapplication.domain.util.ConstValue.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetProductApi(): ProductListApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
    @Singleton
    @Provides
    fun provideProductDatabase(app: Application): ProductDatabase {
        return Room.databaseBuilder(
            app,
            ProductDatabase::class.java,
            ProductDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideProductRepository(db : ProductDatabase): ProductLocalDatabaseRepository {
        return ProductLocalDatabaseRepositoryImp(db.productDao)
    }
}