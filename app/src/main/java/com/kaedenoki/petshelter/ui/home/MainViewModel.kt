package com.kaedenoki.petshelter.ui.home

import android.app.Activity
import android.app.Application
import androidx.lifecycle.*
import com.kaedenoki.petshelter.model.DataSave
import com.kaedenoki.petshelter.repository.local.SaveService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _saved = MutableLiveData<List<DataSave>>()
    val saved : LiveData<List<DataSave>> get() = _saved

    fun getSavedData(application: Application, activity: Activity) = viewModelScope.launch {
        SaveService(application).getAllSaved().collect {
            it.observe(activity as LifecycleOwner){ saved ->
                _saved.value = saved
            }
        }
    }

    fun removeData(application: Application, dataSave: DataSave) = viewModelScope.launch {
        SaveService(application).removeFromSave(dataSave)
    }
}