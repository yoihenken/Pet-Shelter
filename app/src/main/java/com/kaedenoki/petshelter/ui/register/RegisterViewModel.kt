package com.kaedenoki.petshelter.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaedenoki.petshelter.model.CatListItem
import com.kaedenoki.petshelter.model.DogListItem
import com.kaedenoki.petshelter.model.PetResponse
import com.kaedenoki.petshelter.repository.network.PetServices
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    val TAG = "RegisterViewModel"
    private val _animalCat = MutableLiveData<List<CatListItem?>> ()
    val animalCat : LiveData<List<CatListItem?>> get() = _animalCat

    fun getAnimalCat() = viewModelScope.launch {
        PetServices.getCats {
            _animalCat.value = it.catList
            Log.d(TAG, "getAnimalCat: ${it.catList}")
        }
        
    }

    private val _animalDog = MutableLiveData<List<DogListItem?>>()
    val animalDog : LiveData<List<DogListItem?>> get() = _animalDog

    fun getAnimalDog() = viewModelScope.launch {
        PetServices.getDogs {
            _animalDog.value = it.dogList
            Log.d(TAG, "getAnimalDog: ${it.dogList}")
        }
    }

    private var _animalDetail = MutableLiveData<PetResponse?>()
    val animalDetail : LiveData<PetResponse?>  get() = _animalDetail

    fun getAnimalDetailCat(end : String) = viewModelScope.launch {
        PetServices.getCatDetail(end){
            _animalDetail.value = it
        }
    }

    fun getAnimalDetailDog(end: String) = viewModelScope.launch {
        PetServices.getDogDetail(end){
            _animalDetail.value = it
        }
    }
}