package com.kaedenoki.petshelter.ui.register

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.ActivityRegisterBinding
import com.kaedenoki.petshelter.utils.Helpers.hideKeyboard
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val model: RegisterViewModel by viewModels()
    private val TAG = "RegisterAct"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemAnimal = listOf("Cat", "Dog")
        var animal: String
        var type: String

        binding.tfAnimal.apply {
            val adapter = ArrayAdapter(context, R.layout.item_dropdown, itemAnimal)
            (editText as AutoCompleteTextView).setAdapter(adapter)

            (editText as AutoCompleteTextView).setOnItemClickListener { _, view, _, _ ->
                this@RegisterActivity.hideKeyboard(view)
                animal = (editText as AutoCompleteTextView).text.toString()
                type = selectDropdown(animal)
                Log.d(TAG, "onCreate: $animal")
            }
        }

        binding.apply {
            btnCancel.setOnClickListener { finish() }
            btnBack.setOnClickListener { finish() }
        }
    }

    private fun selectDropdown(animal: String) = with(binding) {
        Log.d(TAG, "onCreateAfter: $animal")

        var type = ""
        when (animal) {
            "Cat" -> {
                model.apply {
                    getAnimalCat()
                    animalCat.observe(this@RegisterActivity) {
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
                                Log.d(TAG, "onCreate: $animal")
                            }
                        }
                    }
                }
            }
            "Dog" -> {
                model.apply {
                    getAnimalDog()
                    animalDog.observe(this@RegisterActivity) {
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
                                Log.d(TAG, "onCreate: $animal")
                            }
                        }
                    }
                }
            }
            else -> type = ""
        }
        return@with type
    }
}