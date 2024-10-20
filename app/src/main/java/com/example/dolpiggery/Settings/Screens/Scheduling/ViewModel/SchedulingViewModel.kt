package com.example.dolpiggery.Settings.Screens.Scheduling.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.Settings.Screens.Scheduling.DataClass.SchedulingDataClass
import com.example.dolpiggery.Settings.Screens.Scheduling.Repository.SchedulingRepository

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