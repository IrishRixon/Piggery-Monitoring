package com.example.dolpiggery.MainScreen.ViewModel.Scheduling

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Scheduling.SchedulingDataClass
import com.example.dolpiggery.MainScreen.Repository.Scheduling.SchedulingRepository

class SchedulingViewModel: ViewModel() {
    val scheduleRepository = SchedulingRepository()

    val scheduleList = mutableStateListOf<SchedulingDataClass>()

    fun addScheduleList() {
        scheduleRepository.getScheduleList{
            Log.i("Hey", "Im here master")
            scheduleList.clear()
            scheduleList.addAll(it)
        }
        Log.i("Hey", "scheduleList: $scheduleList")
    }

    fun toggleSwitch(status: Boolean, schedID: String) {
        scheduleRepository.toggleSwitch(status, schedID)
    }
}