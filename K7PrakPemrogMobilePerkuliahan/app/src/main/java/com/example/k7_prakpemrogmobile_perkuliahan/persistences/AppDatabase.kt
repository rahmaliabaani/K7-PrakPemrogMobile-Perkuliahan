package com.example.k7_prakpemrogmobile_perkuliahan.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.k7_prakpemrogmobile_perkuliahan.model.Matkul

@Database(entities = [Matkul::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matkulDao(): MatkulDao
}