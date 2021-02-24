package com.core.plantxapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.core.plantxapp.R
import com.core.plantxapp.data.PlantInfoRepository
import com.core.plantxapp.data.model.PlantInfo
import com.core.plantxapp.databinding.ActivityMainBinding
import com.core.plantxapp.ui.adapter.PlantAdapter
import com.core.plantxapp.ui.viewmodel.PlantViewModel
import com.core.plantxapp.ui.viewmodel.PlantViewModelFactory

class PlantListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : PlantAdapter
    private lateinit var plantViewModel: PlantViewModel
    val list: MutableList<PlantInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        var repository  = PlantInfoRepository()

        //Initialize View Model
        plantViewModel = ViewModelProvider(this,PlantViewModelFactory(repository)).get(PlantViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
        plantViewModel.getPlantList().observe(this ,{
            it?.let {
                adapter = PlantAdapter(this, it)
                binding.recyclerMain.adapter = adapter
            }
        })
    }

}