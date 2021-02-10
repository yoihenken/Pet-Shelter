package com.kaedenoki.petshelter.repository.local

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.kaedenoki.petshelter.model.DataSave

@Dao
interface SaveDao {

    @Insert
    suspend fun insert(dataSave: DataSave)

    @Delete
    suspend fun delete(dataSave: DataSave)

    @Update
    suspend fun update(dataSave: DataSave)

    @Query("select * from DataSave")
    fun getAllSave() : LiveData<List<DataSave>>

    @Query("select * from DataSave")
    fun getAllSaveMain() : List<DataSave>

    @Query("select * from DataSave")
    fun getAllData() : Cursor
}