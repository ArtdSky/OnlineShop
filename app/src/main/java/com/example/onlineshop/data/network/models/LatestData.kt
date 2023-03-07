package com.example.onlineshop.data.network.models

import com.squareup.moshi.Json

data class LatestData(
    val latest: ArrayList<Latest> = arrayListOf()
)


data class Latest(
    val category: String? = null,
    val name: String? = null,
    val price: Int? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null

)