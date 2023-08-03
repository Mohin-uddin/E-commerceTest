package com.example.e_commercetestapplication.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import javax.annotation.Nonnull

@Entity( tableName = "product_list")
data class ProductItem(

    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = false)
    @Nonnull
    val id: Int,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "price")
    val price: Double,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "category")
    val category: String,
    @field:Json(name = "thumbnail")
    val image: String,
    var counter: Int = 0,
    var productStatus: String = "No"

)
