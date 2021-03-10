package com.kaedenoki.petshelter.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.ActivityDetailBinding
import com.kaedenoki.petshelter.model.DataSave

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private lateinit var dataSave : DataSave

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get data intent
        dataSave = intent.getParcelableExtra<DataSave>(EXTRA_DATASAVE) ?: DataSave()

        binding.apply {
            topAppBar.apply {
                title = dataSave.name
                setNavigationOnClickListener {
                    finish()
                }
            }
            idPetContent.text = dataSave.id.toString()
            namePet.text = dataSave.name
            nameAnimalContent.text = dataSave.animal
            typeAnimalContent.text = dataSave.type
            roomPetContent.text = dataSave.room

            when(dataSave.animal){
                "Cat" -> imgAnimal.load(R.drawable.ic_cat)
                "Dog" -> imgAnimal.load(R.drawable.ic_dog)
            }
        }
    }

    companion object{
        var EXTRA_DATASAVE = "extra_datasave"
    }
}