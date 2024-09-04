package com.example.dolpiggery.MainScreen.ViewModel.Pigs

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.Pig.PigDataClass
import com.example.dolpiggery.MainScreen.Repository.Pigs.PigsRepository

class PigsViewModel: ViewModel() {
    val pigsRepository = PigsRepository()

    val pigsList = mutableStateListOf<PigDataClass>()

    fun addPigs(cubicleID: Int) {
        pigsRepository.addPigsList(cubicleID) {
            pigsList.clear()
            pigsList.addAll(it)
        }
    }
}