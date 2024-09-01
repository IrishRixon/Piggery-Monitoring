package com.example.dolpiggery.MainScreen.ViewModel.Cubicles

import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass

class CubiclesViewModel : ViewModel() {
    val cubiclesList = mutableListOf<CubicleDataClass>()
}