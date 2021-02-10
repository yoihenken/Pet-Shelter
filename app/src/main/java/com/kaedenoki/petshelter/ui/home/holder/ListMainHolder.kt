package com.kaedenoki.petshelter.ui.home.holder

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.ItemListBinding
import com.kaedenoki.petshelter.model.DataSave
import com.kaedenoki.petshelter.ui.home.MainViewModel

class ListMainHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemListBinding.bind(itemView)

    fun bindView(data: DataSave, context: Context, model: MainViewModel) = with(binding) {
        namePet.text = data.name
        animalPet.text = data.animal
        typePet.text = data.type
        roomPet.text = data.room

        when(data.animal){
            "Cat" -> {
                imgAnimal.load(R.drawable.ic_cat)
            }
            "Dog" -> {
                imgAnimal.load(R.drawable.ic_dog)
            }
        }

        btnDelete.setOnClickListener {
            model.removeData((context as Activity).application, data)
        }
    }

}