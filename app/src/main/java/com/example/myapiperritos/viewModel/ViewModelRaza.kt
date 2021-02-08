package com.example.myapiperritos.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
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

    fun getfetchRazaWithCoroutines() = viewModelScope.launch {
        repository.getRazaWithCoroutines()
    }

    fun getRazaBD(id: String): LiveData<List<ImageRaza>>{
         return repository.getRazaBD(id)
    }

}