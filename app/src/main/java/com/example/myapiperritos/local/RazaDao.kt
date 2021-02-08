package com.example.myapiperritos.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.remote.ImageRaza

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazaDao(raza: List<Raza>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageRaza(list: List<ImageRaza>)

    @Query("SELECT * FROM raza_table")
    fun getAllRazaDao(): LiveData<List<Raza>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun getAllRazaDao2(raza: List<Raza>)

    @Query("SELECT * FROM image_table WHERE imgURL = :raza")
    fun getAllImageRazaDao(raza: String): LiveData<List<ImageRaza>>

}