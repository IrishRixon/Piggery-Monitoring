package com.example.dolpiggery.MainScreen.ViewModel.Scheduling.AddSchedViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddSchedViewModel : ViewModel() {
    var hour = mutableStateOf("")
    var minute = mutableStateOf("")
    var amOrPm = mutableStateOf("")

    fun setHour(hour: Int) {
        this.hour.value = "$hour"
    }

    fun setMinute(minute: Int) {
        this.minute.value = "$minute"
    }

    fun setAmOrPm(amOrPm: String) {
        this.amOrPm.value = amOrPm
    }

    fun getHour(): String {
        return hour.value
    }

    fun getMinute(): String {
        return minute.value
    }

    fun getAmOrPm(): String {
        return amOrPm.value
    }
}