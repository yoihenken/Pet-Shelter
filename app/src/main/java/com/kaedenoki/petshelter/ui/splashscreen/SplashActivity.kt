package com.kaedenoki.petshelter.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.model.DataDummy
import com.kaedenoki.petshelter.ui.home.MainActivity
import com.kaedenoki.petshelter.ui.register.RegisterViewModel

class SplashActivity : AppCompatActivity() {

    private val modelRegister = RegisterViewModel()
    private val dataDummy = DataDummy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        dataDummy.dummy.forEach {
            modelRegister.saveData(this.application, it)
        }

        Handler(mainLooper).postDelayed({
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}