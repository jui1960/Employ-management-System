package com.example.employmanagementsystem

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employ_data")
data class Data (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val img : String?,
    val name : String,
    val position : String,
    val education : String,
    val salary : Int
)
