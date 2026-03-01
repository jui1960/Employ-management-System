package com.example.employmanagementsystem

import androidx.lifecycle.LiveData

class Repository(private val dataDaoRepo: EmployDao) {


    fun getAllRepo():List<Data> {
        return dataDaoRepo.getalldata()
    }

    fun insertRepo(data: Data) {
        return dataDaoRepo.insert(data)
    }

    fun updateRepo(data: Data) {
        return dataDaoRepo.update(data)
    }

    fun deleteRepo(data: Data) {
        return dataDaoRepo.delete(data)
    }



}