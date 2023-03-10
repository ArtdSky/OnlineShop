package com.example.onlineshop.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val first_name: String,
    val last_name : String,
    val email: String
)
