package com.example.employmanagementsystem

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Data::class], version = 1)
abstract class Appdatabase : RoomDatabase() {

    abstract fun employDao(): EmployDao


    companion object {
        private var INSTANCE: Appdatabase? = null

        fun getDatabase(context: Context): Appdatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    Appdatabase::class.java,
                    "employ_db"
                )
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE!!
        }
    }
}