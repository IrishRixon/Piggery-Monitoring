package com.example.dolpiggery.MainScreen.ViewModel.Cubicles

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.Repository.Cubicles.CubiclesRepository

class CubiclesViewModel : ViewModel() {
    val cubiclesRepository = CubiclesRepository()

    var bpm = mutableStateOf("--")
    var bodyTemp = mutableStateOf("--")

    fun setBPM() {
        val keyToCompare = "BPM"
        cubiclesRepository.getHeartBeat(keyToCompare) { bpm.value = it }
    }

    fun setBodyTemp() {
        val keyToCompare = "BodyTemp"
        cubiclesRepository.getHeartBeat(keyToCompare) { bodyTemp.value = it }
    }
}