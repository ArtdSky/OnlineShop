package com.example.onlineshop.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LatestData(
    @Json(name = "latest")
    val latest: List<Latest> = listOf()
)

@JsonClass(generateAdapter = true)
data class Latest(
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null

)