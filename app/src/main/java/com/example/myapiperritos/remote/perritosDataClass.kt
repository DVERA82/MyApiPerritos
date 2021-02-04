package com.example.myapiperritos

import com.google.gson.annotations.SerializedName

data class perritosDataClass(@SerializedName("message")
                             val message:List<String>,
                             @SerializedName("status")
                             val status: String)

data class imageDataB
(@SerializedName("message")
 val message: List<String>,
 @SerializedName("status")
 val status: String)
