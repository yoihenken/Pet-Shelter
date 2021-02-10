package com.kaedenoki.petshelter.repository.local

import android.app.Application
import com.kaedenoki.petshelter.model.DataSave
import kotlinx.coroutines.flow.flow

class SaveService (application: Application) {

    private var saveDao : SaveDao
    private val database = SaveDatabase.getInstance(application)
    private val databaseMain = SaveDatabase.getInstanceMainThread(application)

    init {
        saveDao = database.saveDao()
    }

    suspend fun addToSave(dataSave : DataSave){
        saveDao.insert(dataSave)
    }

    suspend fun removeFromSave(dataSave: DataSave){
        saveDao.delete(dataSave)
    }

    suspend fun getAllSaved() = flow {
        emit(saveDao.getAllSave())
    }

    fun getAllData() = saveDao.getAllData()

}