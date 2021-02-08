package com.example.myapiperritos

import com.google.gson.annotations.SerializedName

data class PerritosDataClass(@SerializedName("message")
                             val message:List<String>,

                             @SerializedName("status")
                             val status: String)



data class ImageDataClass
    (@SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String)
