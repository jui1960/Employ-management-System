package com.example.employmanagementsystem

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EmployDao {
    @Insert
    fun insert(employdata : Data)

    @Update
    fun update(employdata :  Data)

    @Delete
    fun delete(employdata: Data)

    @Query("SELECT * FROM `employ data` ORDER By id DESC")
    fun getalldata(): LiveData<List<Data>>
}