package com.example.e_commercetestapplication.di

import android.app.Application
import androidx.room.Room
import com.example.e_commercetestapplication.data.data_source.ProductDao
import com.example.e_commercetestapplication.data.data_source.ProductDatabase
import com.example.e_commercetestapplication.data.data_source.ProductDatabase_Impl
import com.example.e_commercetestapplication.data.remote.ProductListApi
import com.example.e_commercetestapplication.data.reprository.ProductLocalDatabaseRepositoryImp
import com.example.e_commercetestapplication.domain.repository.ProductLocalDatabaseRepository
import com.example.e_commercetestapplication.domain.util.ConstValue
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Singleton
    @Provides
    fun provideGetProductApi(): ProductListApi {
        return Retrofit.Builder()
            .baseUrl(ConstValue.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ProductListApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): ProductDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            ProductDatabase::class.java,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: ProductDatabase): ProductLocalDatabaseRepository {
        return ProductLocalDatabaseRepositoryImp(db.productDao)
    }

}