package com.core.plantxapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.core.plantxapp.data.PlantInfoRepository

class PlantViewModelFactory(private val repository: PlantInfoRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantViewModel(repository) as T
    }

}