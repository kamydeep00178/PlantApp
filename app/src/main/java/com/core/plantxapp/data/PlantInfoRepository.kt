package com.core.plantxapp.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.core.plantxapp.data.model.PlantInfo

class PlantInfoRepository {


    var plantList: MutableList<PlantInfo> = mutableListOf()


    fun getPlantList() : MutableLiveData<List<PlantInfo>> {
        var mutableLiveData = MutableLiveData<List<PlantInfo>>()
       // Get From DB
        plantList = getPlantListFromDB()
        //Check if No data found from db , Call to Network Rest API and Save into Local DB
        if (plantList?.size!! == 0) // Check if Not found from db
        {
            plantList = getPlantListFromNetwork() // call Network api
            addToPlantListFromDB(plantList)  // Save API Data INTO DB;
        }
        mutableLiveData.value=plantList
        return mutableLiveData
    }


    // get from Network
    fun getPlantListFromNetwork() : MutableList<PlantInfo>
    {
        Log.d("TAG", "getPlantListFromNW:")

        // Mock Data
        var list: MutableList<PlantInfo> = mutableListOf()
        var plantInfo = PlantInfo("American Marigold","Tagetes erecta")
        list.add(plantInfo)
        plantInfo = PlantInfo("Annual Vinca","Catharanthus roseus")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bacopa","Sutera cordata")
        list.add(plantInfo)
        plantInfo = PlantInfo("Balloon Flower","Platycodon grandiflorus")
        list.add(plantInfo)
        plantInfo = PlantInfo("Beautybush","Kolkwitzia amabilis")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bee-Balm","Monarda didyma")
        list.add(plantInfo)
        plantInfo = PlantInfo("Black-eyed Susan","Rudbeckia hirta")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bleeding-heart","Dicentra spectabilis")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bloody Cranesbill","Geranium sanguineum")
        list.add(plantInfo)
        plantInfo = PlantInfo("Blue Fescue","Festuca glauca")
        list.add(plantInfo)
        plantInfo = PlantInfo("Caladium","Caladium x hortulanum")
        list.add(plantInfo)
        return list
    }

    // get from DB
    fun getPlantListFromDB() : MutableList<PlantInfo>
    {
        Log.d("TAG", "getPlantListFromDB:")

        var list: MutableList<PlantInfo> = mutableListOf()

        // Uncomment only get Data from  DB

        // Mock Data
       /* var plantInfo = PlantInfo("American Marigold","Tagetes erecta")
        list.add(plantInfo)
        plantInfo = PlantInfo("Annual Vinca","Catharanthus roseus")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bacopa","Sutera cordata")
        list.add(plantInfo)
        plantInfo = PlantInfo("Balloon Flower","Platycodon grandiflorus")
        list.add(plantInfo)
        plantInfo = PlantInfo("Beautybush","Kolkwitzia amabilis")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bee-Balm","Monarda didyma")
        list.add(plantInfo)
        plantInfo = PlantInfo("Black-eyed Susan","Rudbeckia hirta")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bleeding-heart","Dicentra spectabilis")
        list.add(plantInfo)
        plantInfo = PlantInfo("Bloody Cranesbill","Geranium sanguineum")
        list.add(plantInfo)
        plantInfo = PlantInfo("Blue Fescue","Festuca glauca")
        list.add(plantInfo)
        plantInfo = PlantInfo("Caladium","Caladium x hortulanum")
        list.add(plantInfo)*/

      return list
    }


    // add to db;
    fun addToPlantListFromDB(list: MutableList<PlantInfo>)
    {
        Log.d("TAG", "Save INTo DB:")
        plantList=list
    }


}