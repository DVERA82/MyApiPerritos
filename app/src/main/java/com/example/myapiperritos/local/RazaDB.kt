package com.example.myapiperritos.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.remote.ImageRaza

@Database(entities = [Raza::class, ImageRaza::class], version = 1 )
abstract class RazaDB : RoomDatabase(){

    abstract  fun getRazaDao(): RazaDao

    companion object {
        @Volatile
        private var INSTANCE: RazaDB? = null

        fun getRazaDB(context: Context): RazaDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    RazaDB::class.java, "RazaDB")
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}