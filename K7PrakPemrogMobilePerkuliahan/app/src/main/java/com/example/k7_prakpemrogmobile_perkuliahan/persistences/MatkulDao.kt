package com.example.k7_prakpemrogmobile_perkuliahan.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.k7_prakpemrogmobile_perkuliahan.model.Matkul

@Dao
interface MatkulDao {
    @Query("SELECT * FROM Matkul ORDER BY kode DESC")
    fun loadAll(): LiveData<List<Matkul>>
    @Query("SELECT * FROM Matkul ORDER BY kode DESC")
    suspend fun getList(): List<Matkul>
    @Query("SELECT * FROM Matkul WHERE id = :id")
    suspend fun find(id: String): Matkul?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Matkul)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Matkul>)
    @Delete
    fun delete(item: Matkul)
    @Query("DELETE FROM Matkul WHERE id = :id")
    fun delete(id: String)
}