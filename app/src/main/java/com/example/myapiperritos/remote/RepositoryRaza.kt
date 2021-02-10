package com.example.myapiperritos.remote

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapiperritos.local.RazaDao
import com.example.myapiperritos.pojo.Raza

class RepositoryRaza (private val dao: RazaDao) {

    private val services = RetrofitClient.retrofitInstance()
    val LiveDataRazaDaoDB: LiveData<List<Raza>> = dao.getAllRazaDao()
    val listFavorityImages = dao.getAllFavorityImages()

    fun converterRaza(converterRaza: List<String>): List<Raza> {
        val listRaza: MutableList<Raza> = mutableListOf()
        converterRaza.map {
            listRaza.add(Raza(raza = it))
        }

        return listRaza
    }

    fun converterImage(converterImage: List<String>, raza: String): List<ImageRaza> {
        val listImage: MutableList<ImageRaza> = mutableListOf()
        converterImage.map {
            listImage.add(ImageRaza(imgURL = it, status = raza, favority = false))
        }

        return listImage
    }


    // funcion que utiliza las corrutinas para la conexxión al servicio
    suspend fun getRazaWithCoroutines() {
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = RetrofitClient.retrofitInstance().fetchRazaList()
            when (response.isSuccessful) {
                true -> response.body()?.let {

                    dao.insertAllRazaDao(converterRaza(it.message))
                }

                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()}")
            }

        } catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }

    }

    suspend fun imageRaza(id: String) {

        try {
            val response = RetrofitClient.retrofitInstance().fetchImagesbyraza(id)
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    //Log.d("repo","$(it)")
                    dao.insertAllImageRaza(converterImage(it.message,id))
                }
                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()}")
            }

        }
        catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }



    }
    fun getRazaBD(id: String): LiveData<List<ImageRaza>> {
        return dao.getAllImageRazaDao(id)
    }
     suspend fun updateFavImages(imagesRaza: ImageRaza) { // esto va ser el update de fav
         dao.updateImageRaza(imagesRaza)
     }
}



