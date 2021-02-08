package com.example.myapiperritos.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val URL_BASE ="https://dog.ceo/api/"


        fun retrofitInstance(): InterfaceRaza {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(InterfaceRaza::class.java)

        }


    }
}