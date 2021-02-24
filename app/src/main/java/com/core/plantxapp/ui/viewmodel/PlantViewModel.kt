package com.core.plantxapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.core.plantxapp.data.PlantInfoRepository
import com.core.plantxapp.data.model.PlantInfo

class PlantViewModel(var repository: PlantInfoRepository) : ViewModel( ) {

    fun getPlantList() : LiveData<List<PlantInfo>> = repository.getPlantList()

}