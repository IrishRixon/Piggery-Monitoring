package com.example.dolpiggery.Pigs.ViewModel.Cubicles

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.Pigs.DataClass.Pigs.PigsDataClass
import com.example.dolpiggery.Pigs.Repository.PigsRepository

class CubiclesViewModel : ViewModel() {
    val cubiclesRepository = PigsRepository() // Create an instance of CubicleRepository

    val pigsList = mutableStateListOf<PigsDataClass>() // initialize a mutable state of list that takes CubicleDataClass

    var minutesString: String = "--"
    var secondsString: String = "--"

    // A function to invoke the getCubiclesList function, and pass a lambda to clear and then addAll the list
    fun addCubicles(){
       cubiclesRepository.getPigsList {
           pigsList.clear()
           pigsList.addAll(it)
       }
    }

    // function to toggle the Sprinkler switch
    fun toggleSprinklerSwitch(currentSatus: Boolean ,cubicleID: Int) {
        cubiclesRepository.toggleSprinklerSwitch(currentSatus, cubicleID)
    }

    fun zeroPaddingTimer(timer: Int) {
        if(timer != 0) {
            val totalSeconds = timer / 1000
            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60

            minutesString = if (minutes < 10) "0$minutes" else "$minutes"
            secondsString = if (seconds < 10) "0$seconds" else "$seconds"
        }
    }

}