package com.example.k7_prakpemrogmobile_perkuliahan.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.k7_prakpemrogmobile_perkuliahan.model.Dosen
import com.example.k7_prakpemrogmobile_perkuliahan.model.Mahasiswa
import com.example.k7_prakpemrogmobile_perkuliahan.model.Matkul

@Database(entities = [Matkul::class, Dosen::class, Mahasiswa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    dosen
    abstract fun dosenDao(): DosenDao
//    mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao
//    matkul
    abstract fun matkulDao(): MatkulDao

}