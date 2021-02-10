package com.kaedenoki.petshelter.ui.home.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaedenoki.petshelter.R

class HeaderHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val itemHeader = itemView.findViewById(R.id.tvHeaderItem) as TextView

    fun bindContent(text : String){
        itemHeader.text = text
    }
}