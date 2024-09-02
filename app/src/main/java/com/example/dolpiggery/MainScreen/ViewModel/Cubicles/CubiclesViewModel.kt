package com.example.dolpiggery.MainScreen.ViewModel.Cubicles

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass
import com.example.dolpiggery.MainScreen.Repository.Cubicles.CubiclesRepository

class CubiclesViewModel : ViewModel() {
    val cubiclesRepository = CubiclesRepository()

    val cubicleList = mutableStateListOf<CubicleDataClass>()

    fun addCubicles(){
       cubiclesRepository.getCubiclesList {
           cubicleList.clear()
           cubicleList.addAll(it)
       }
    }

    fun toggleSprinklerSwitch(currentSatus: Boolean ,cubicleID: Int) {
        cubiclesRepository.toggleSprinklerSwitch(currentSatus, cubicleID)
    }

}