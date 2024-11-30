package com.example.dolpiggery.HealthHistory.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.HealthHistory.DataClass.pigList

class HealthHistoryViewModel : ViewModel(){
    val listOfPigs = mutableStateListOf<pigList>()

    fun addPig(){

    }
}