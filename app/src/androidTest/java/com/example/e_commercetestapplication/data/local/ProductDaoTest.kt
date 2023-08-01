package com.example.e_commercetestapplication.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.e_commercetestapplication.data.data_source.ProductDao
import com.example.e_commercetestapplication.data.data_source.ProductDatabase
import com.example.e_commercetestapplication.data.remote.ProductItem
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDaoTest {
    private lateinit var database : ProductDatabase
    private lateinit var dao : ProductDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ProductDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDao
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertProductItem() = runBlocking {
        val productItem = ProductItem(id=1, title = "Apple", price =1222.23434,
            description = "Apple brans 14 pro", category = "Mobile", image = "image", counter = 0 )
        dao.insertProductItem(productItem = productItem)
        val allProductList = dao.getAllProduct()
    }
}