package com.example.dolpiggery.MainScreen.ViewModel.Cubicles

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass
import com.example.dolpiggery.MainScreen.Repository.Cubicles.CubiclesRepository

class CubiclesViewModel : ViewModel() {
    val cubiclesRepository = CubiclesRepository() // Create an instance of CubicleRepository

    val cubicleList = mutableStateListOf<CubicleDataClass>() // initialize a mutable state of list that takes CubicleDataClass

    // A function to invoke the getCubiclesList function, and pass a lambda to clear and then addAll the list
    fun addCubicles(){
       cubiclesRepository.getCubiclesList {
           cubicleList.clear()
           cubicleList.addAll(it)
       }
    }

    // function to toggle the Sprinkler switch
    fun toggleSprinklerSwitch(currentSatus: Boolean ,cubicleID: Int) {
        cubiclesRepository.toggleSprinklerSwitch(currentSatus, cubicleID)
    }

}