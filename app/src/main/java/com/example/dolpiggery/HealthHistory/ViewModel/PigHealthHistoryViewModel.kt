package com.example.dolpiggery.HealthHistory.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.HealthHistory.DataClass.PigHealthHistoryDataClass
import com.example.dolpiggery.HealthHistory.Repository.PigHealthHistoryRepository

class PigHealthHistoryViewModel: ViewModel() {
    val pigHealthHistoryRepository = PigHealthHistoryRepository()
    val listOfHealthHistory = mutableStateListOf<PigHealthHistoryDataClass>()

    fun addHealthHistory(pigID: Int) {
        Log.i("arisoh", "ViewModel: Dito")

        pigHealthHistoryRepository.addPigHealthHistory(pigID) {
            listOfHealthHistory.clear()
            listOfHealthHistory.addAll(it)
        }
    }
}