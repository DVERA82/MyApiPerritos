
package com.example.myapiperritos.remote

import com.example.myapiperritos.PerritosDataClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceRaza {

    @GET ("breeds/list")
    suspend fun fetchRazaList():Response<PerritosDataClass>

    @GET("breed/{raza}/images")
    suspend fun fetchImagesbyraza(@Path ("raza") raza: String) : Response<ImageRaza>

}

