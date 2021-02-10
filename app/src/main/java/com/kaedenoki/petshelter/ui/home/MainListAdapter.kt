package com.kaedenoki.petshelter.ui.home

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaedenoki.petshelter.R
import com.kaedenoki.petshelter.model.DataSave
import com.kaedenoki.petshelter.ui.home.holder.HeaderHolder
import com.kaedenoki.petshelter.ui.home.holder.ListMainHolder
import java.lang.IllegalArgumentException

class MainListAdapter(
    private val listData : List<Any>,
    private val activity: Activity,
    private val model: MainViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = getLayout(viewType)
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return getViewHolder(viewType, view)
    }

    private fun getViewHolder(viewType: Int, view: View) = when(viewType){
        ITEM_HEADER -> HeaderHolder(view)
        ITEM_LIST -> ListMainHolder(view)
        else -> throw IllegalArgumentException("Undefined viewtype")
    }

    private fun getLayout(viewType: Int) = when(viewType){
        ITEM_HEADER -> R.layout.item_header
        ITEM_LIST -> R.layout.item_list
        else -> Log.d("ListMainAdapter", "getLayout: Undefined viewType")
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            ITEM_HEADER -> (holder as HeaderHolder).bindContent(listData[position] as String)
            ITEM_LIST -> (holder as ListMainHolder).bindView(listData[position] as DataSave, activity, model)
        }
    }

    override fun getItemViewType(position: Int) = when(listData[position]){
        is String -> ITEM_HEADER
        is DataSave -> ITEM_LIST
        else -> Log.d("ListMainAdapter", "getLayout: Undefined viewType")
    }

    override fun getItemCount(): Int = listData.size

    companion object{
        private val ITEM_HEADER = 0
        private val ITEM_LIST = 1
    }
}