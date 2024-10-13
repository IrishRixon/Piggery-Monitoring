package com.example.dolpiggery.Settings.ViewModel.AddSchedViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddSchedViewModel : ViewModel() {
    var hour = mutableStateOf("")
    var minute = mutableStateOf("")
    var amOrPm = mutableStateOf("")

    val daysRepeatList = mutableStateListOf<Int>()
    val targetsList = mutableStateListOf<Int>()

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

    fun addTarget(target: Int) {
        targetsList.add(target)
    }

    fun removeTarget(target: Int) {
        targetsList.remove(target)
    }

    fun setDaysRepeat(days: List<Int>) {
        daysRepeatList.clear()
        daysRepeatList.addAll(days)
    }

    fun setTargets(targets: List<Int>) {
        targetsList.clear()
        targetsList.addAll(targets)
    }

}