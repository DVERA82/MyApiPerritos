package com.example.myapiperritos

import android.media.Image
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.remote.ImageRaza

fun fromRemoteToEntityRaza(perritosDataClass: PerritosDataClass): List<Raza> {
    return perritosDataClass?.message.map { Raza(it) }


}

/*fun fromRemoteToEntityImageRaza(image: ImageDataClass,raza:String): List<ImageRaza> {
    return image?.message.map { ImageRaza(imgURL = it, raza = raza, favority= false) }*/
