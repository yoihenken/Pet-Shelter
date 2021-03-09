package com.kaedenoki.petshelter.ui.home

import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import coil.load
import coil.transform.CircleCropTransformation
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.databinding.DialogAboutBinding

class AboutDialog (var activity: Activity) {
    private lateinit var alertDialog: AlertDialog
    private lateinit var binding : DialogAboutBinding

    fun startDialog(){
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        binding = DialogAboutBinding.inflate(activity.layoutInflater)

        binding.apply {
            imgGithub.load("https://image.flaticon.com/icons/png/512/25/25231.png")
            photoProfile.load("https://avatars.githubusercontent.com/u/45727096?s=460&u=f4680d3788d290c9512540579d24370a64c71bf2&v=4"){
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

        alertDialog = builder.create()
        alertDialog.setView(binding.root, 50, 50, 50, 50)
        alertDialog.show()
        alertDialog.window?.setLayout(800,800)
//        Log.d("AboutDialog", "startDialog: ${binding.dialogAbout.measuredWidth}")
//        Log.d("AboutDialog", "startDialog: ${binding.dialogAbout.width}")
//        Log.d("AboutDialog", "startDialog: ${binding.dialogAbout.maxWidth}")
//        alertDialog.window?.setLayout(binding.dialogAbout.height, binding.dialogAbout.width)
    }

    fun dismissDialog(){
        alertDialog.dismiss()
    }
}