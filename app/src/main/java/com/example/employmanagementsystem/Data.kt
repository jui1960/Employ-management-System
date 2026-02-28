package com.example.employmanagementsystem

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employ data")
data class Data (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val img : Int,
    val name : String,
    val position : String,
    val education : String,
    val age : Int
)
