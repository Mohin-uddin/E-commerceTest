package com.example.e_commercetestapplication.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_commercetestapplication.data.remote.ProductItem


@Database(
    entities = [ProductItem::class],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase(){

    abstract val productDao: ProductDao

    companion object{
        const val DATABASE_NAME = "product_db"
    }
}