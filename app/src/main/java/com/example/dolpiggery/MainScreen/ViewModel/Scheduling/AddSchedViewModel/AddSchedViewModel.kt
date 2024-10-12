package com.example.dolpiggery.MainScreen.ViewModel.Scheduling.AddSchedViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddSchedViewModel : ViewModel() {
    var hour = mutableStateOf("")
    var minute = mutableStateOf("")
    var amOrPm = mutableStateOf("")

    val daysRepeatList = mutableStateListOf<Int>()

    fun setHour(hour: Int) {
        this.hour.value = "$hour"
    }

    fun setMinute(minute: Int) {
        this.minute.value = "$minute"
    }

    fun setAmOrPm(amOrPm: String) {
        this.amOrPm.value = amOrPm
    }

    fun addDayRepeat(day: Int) {
        daysRepeatList.add(day)
    }

    fun removeDayRepeat(day: Int) {
        daysRepeatList.remove(day)
    }
}