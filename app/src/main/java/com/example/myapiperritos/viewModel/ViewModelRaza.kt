package com.example.myapiperritos.viewModel

import android.app.Application
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.remote.ImageRaza
import com.example.myapiperritos.local.RazaDB
import com.example.myapiperritos.remote.RepositoryRaza
import kotlinx.coroutines.launch


class ViewModelRaza (application: Application)  : AndroidViewModel(application) {

    private val repository: RepositoryRaza
    val razaLiveDataFromDB: LiveData<List<Raza>>



    init {
        val dao = RazaDB.getRazaDB(application).getRazaDao()
        repository = RepositoryRaza(dao)
        viewModelScope.launch {
            repository.getRazaWithCoroutines()
        }
        razaLiveDataFromDB = repository.LiveDataRazaDaoDB
    }

    fun getAllFavList(): LiveData<List<ImageRaza>> = repository.listFavorityImages  // this return all
    //fav from dataBase

    fun updateFavorityImages(imageRaza: ImageRaza)= viewModelScope.launch {
        repository.updateFavImages(imageRaza)
    }

    fun getfetchRazaWithCoroutines(id: String) = viewModelScope.launch {
        repository.imageRaza(id)
    }


    fun getRazaBD(id: String): LiveData<List<ImageRaza>>{
         return repository.getRazaBD(id)
    }


}