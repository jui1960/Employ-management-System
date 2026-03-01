package com.example.employmanagementsystem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class EmployViewModel(application: Application): AndroidViewModel(application) {

    private val repository : Repository


    val liveData = MutableLiveData<List<Data>>()
    init {
        val dao = Appdatabase.getDatabase(application).employDao()
        repository = Repository(dao)
        loadDataView()
    }

    fun loadDataView(){
       liveData.value = repository.getAllRepo()
    }

    fun insertView(data: Data){
        repository.insertRepo(data)
        loadDataView()
    }
    fun updateView(data: Data){
        repository.updateRepo(data)
        loadDataView()
    }
    fun deleteView(data: Data){
        repository.deleteRepo(data)
        loadDataView()
    }
}