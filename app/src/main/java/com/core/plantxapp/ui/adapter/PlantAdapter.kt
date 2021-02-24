package com.core.plantxapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.core.plantxapp.R
import com.core.plantxapp.data.model.PlantInfo
import com.core.plantxapp.databinding.ItemRowBinding

class PlantAdapter(var context: Context,var plantList : List<PlantInfo>) :
    RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    class PlantHolder(var itemRowBinding: ItemRowBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {
    fun bind(plantInfo: PlantInfo)
    {
        itemRowBinding.plant=plantInfo
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemRowBinding: ItemRowBinding = DataBindingUtil.inflate(layoutInflater,R.layout.item_row,parent,false)
        return PlantHolder(itemRowBinding)


    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
       val data=plantList.get(position)
       holder.bind(data)
    }

    override fun getItemCount(): Int = plantList.size
}