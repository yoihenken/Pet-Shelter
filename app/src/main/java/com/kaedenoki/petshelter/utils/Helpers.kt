package com.kaedenoki.petshelter.utils

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.kaedenoki.petshelter.model.DataSave


object Helpers {

    fun Activity.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.applicationWindowToken, 0)
    }

    fun List<DataSave>.toDataSaveForHolder() : MutableList<Any> {
        val saveCat = mutableListOf<Any>()
        val saveDog = mutableListOf<Any>()
        saveCat.add("Cat")
        saveDog.add("Dog")
        this.forEach {
            when(it.animal.toString()){
                "Cat" -> {
                   saveCat.add(it)
                }
                "Dog" -> {
                    saveDog.add(it)
                }
            }
        }
        saveCat.addAll(saveDog)
        return saveCat
    }
}