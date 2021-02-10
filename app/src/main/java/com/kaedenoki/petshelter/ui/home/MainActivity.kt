package com.kaedenoki.petshelter.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaedenoki.petshelter.databinding.ActivityMainBinding
import com.kaedenoki.petshelter.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRegister.setOnClickListener {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            }
        }
    }
}