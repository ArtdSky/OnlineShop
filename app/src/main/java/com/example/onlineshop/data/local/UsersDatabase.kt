package com.example.onlineshop.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlineshop.data.local.models.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao


    companion object{

        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getDatabase(
            context : Context
        ) : UsersDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsersDatabase::class.java,
                    "shop_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}