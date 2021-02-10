package com.kaedenoki.petshelter.ui.register

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.ActivityRegisterBinding
import com.kaedenoki.petshelter.utils.Helpers.hideKeyboard

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemAnimal = listOf("Cat", "Dog")
        binding.apply {
            val adapter = ArrayAdapter(tfAnimal.context, R.layout.item_dropdown, itemAnimal)
            (tfAnimal.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            tfAnimal.editText?.setOnClickListener {
                this@RegisterActivity.hideKeyboard(it)
            }
        }

        val itemType = listOf("")
        binding.apply {
            val adapter = ArrayAdapter(tfType.context, R.layout.item_dropdown, itemType)
            (tfType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            tfType.editText?.setOnClickListener {
                this@RegisterActivity.hideKeyboard(it)
            }
        }
    }
}