package com.example.myapiperritos.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "raza_table")
data class Raza(@PrimaryKey val raza : String)

