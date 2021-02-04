package com.example.myapiperritos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class ImageRaza(@PrimaryKey val imgURL : String , val raza:String)
