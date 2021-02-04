package com.example.myapiperritos.remote

import com.example.myapiperritos.ImageRaza
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDog {

    @GET ("raza/list")
    suspend fun fetchRazaList():Response<ApiDog>

    @GET("raza/{raza}/images/")
    suspend fun fetchImagesbyraza(@Path ("raza") raza: String) : Response<ImageRaza>
}

