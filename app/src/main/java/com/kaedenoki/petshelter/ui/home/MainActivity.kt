package com.kaedenoki.petshelter.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaedenoki.petshelter.databinding.ActivityMainBinding
import com.kaedenoki.petshelter.model.DataSave
import com.kaedenoki.petshelter.repository.local.SaveService
import com.kaedenoki.petshelter.ui.register.RegisterActivity
import com.kaedenoki.petshelter.utils.Helpers.toDataSaveForHolder

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.getSavedData(application, this)
        model.saved.observe(this) {
            populateDataSave(it)
        }

        binding.apply {
            btnRegister.setOnClickListener {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            }
        }
    }

    private fun populateDataSave(it : List<DataSave>) = with(binding){
        rvPet.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = MainListAdapter(it.toDataSaveForHolder(), this@MainActivity, model)
        }
    }

}