package com.example.myapiperritos.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class ImageRaza(@PrimaryKey val imgURL : String , val status: String, var favority: Boolean)
