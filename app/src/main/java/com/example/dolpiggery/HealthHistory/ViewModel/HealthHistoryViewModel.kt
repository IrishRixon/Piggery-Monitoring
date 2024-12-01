package com.example.dolpiggery.HealthHistory.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.HealthHistory.DataClass.pigList
import com.example.dolpiggery.HealthHistory.Repository.HealthHistoryRepository

class HealthHistoryViewModel : ViewModel(){
    val healthHistoryRepository = HealthHistoryRepository()
    val listOfPigs = mutableStateListOf<pigList>()

    fun addPig(){
        healthHistoryRepository.iteratePigs {
            listOfPigs.clear()
            listOfPigs.addAll(it)
            Log.i("Yowsi", "addPig: $listOfPigs")
        }
    }
}