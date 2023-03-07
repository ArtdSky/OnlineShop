package com.example.onlineshop.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlashSaleData(
    @Json(name = "flash_sale")
    val flashSale: List<FlashSale> = listOf()
)

@JsonClass(generateAdapter = true)
data class FlashSale(
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "discount")
    val discount: Int? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null

)