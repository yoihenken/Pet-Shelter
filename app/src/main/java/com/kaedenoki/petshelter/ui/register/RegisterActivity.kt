package com.kaedenoki.petshelter.ui.register

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.ActivityRegisterBinding
import com.kaedenoki.petshelter.model.DataSave
import com.kaedenoki.petshelter.utils.Helpers.hideKeyboard
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val model: RegisterViewModel by viewModels()
    private val TAG = "RegisterAct"
    private var animal: String = ""
    private var type: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemAnimal = listOf("Cat", "Dog")


        binding.tfAnimal.apply {
            val adapter = ArrayAdapter(context, R.layout.item_dropdown, itemAnimal)
            (editText as AutoCompleteTextView).setAdapter(adapter)
            (editText as AutoCompleteTextView).setOnItemClickListener { _, view, _, _ ->
                this@RegisterActivity.hideKeyboard(view)
                animal = (editText as AutoCompleteTextView).text.toString()
                selectDropdown(animal)
                Log.d(TAG, "onCreateAnimal: $animal")
                Log.d(TAG, "onCreateType: $type")
            }
        }

        binding.apply {
            btnSave.setOnClickListener {
                if (!animal.equals("") && !type.equals("")) saveItem(animal, type)
                else Toast.makeText(this@RegisterActivity, "Fill cant empty !", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
            btnCancel.setOnClickListener { finish() }
            btnBack.setOnClickListener { finish() }
        }
    }

    private fun saveItem(animal: String, type: String) = with(binding) {
        model.saveData(
            application, DataSave(
                name = tfNama.editText?.text.toString(),
                animal = animal,
                type = type,
                room = tfRoom.editText?.text.toString()
            )
        )
    }

    private fun selectDropdown(animal: String) = with(binding) {
        Log.d(TAG, "onCreateAfter: $animal")

        when (animal) {
            "Cat" -> {
                model.getAnimalCat()
                model.animalCat.observe(this@RegisterActivity) {
                    val item = ArrayList<String?>()
                    it.forEach { catListItem ->
                        item.add(catListItem?.name)
                    }
                    Log.d(TAG, "selectDropdown: $item")
                    tfType.apply {
                        (editText as AutoCompleteTextView).setText("")
                        val adapter = ArrayAdapter(tfType.context, R.layout.item_dropdown, item)
                        (tfType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
                        (editText as AutoCompleteTextView).setOnItemClickListener { _, view, _, _ ->
                            this@RegisterActivity.hideKeyboard(view)
                            type = (editText as AutoCompleteTextView).text.toString()
                            Log.d(TAG, "onCreateonCat: $type")
                        }
                    }
                }
            }
            "Dog" -> {
                model.getAnimalDog()
                model.animalDog.observe(this@RegisterActivity) {
                    val item = ArrayList<String?>()
                    it.forEach { dogListItem ->
                        item.add(dogListItem?.name)
                    }
                    Log.d(TAG, "selectDropdown: $item")
                    tfType.apply {
                        (editText as AutoCompleteTextView).setText("")
                        val adapter = ArrayAdapter(tfType.context, R.layout.item_dropdown, item)
                        (tfType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
                        (editText as AutoCompleteTextView).setOnItemClickListener { _, view, _, _ ->
                            this@RegisterActivity.hideKeyboard(view)

                            type = (editText as AutoCompleteTextView).text.toString()
                            Log.d(TAG, "onCreateonDog: $type")
                        }
                    }
                }

            }
            else -> type = ""
        }
        Log.d(TAG, "onCreateAfter: $type")
    }
}