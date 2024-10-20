package com.example.dolpiggery.Settings.Screens.Scheduling.ViewModel.AddSchedViewModel

import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.Settings.Screens.Scheduling.DataClass.AddAndEditScheduleDataClass
import com.example.dolpiggery.Settings.Screens.Scheduling.Repository.AddSchedRepository

class AddSchedViewModel : ViewModel() {
    val addSchedRepository = AddSchedRepository()

    var hour = mutableStateOf("")
    var minute = mutableStateOf("")
    var amOrPm = mutableStateOf("")

    val daysRepeatList = mutableStateListOf<Int>()
    val targetsList = mutableStateListOf<Int>()

    fun setHour(hour: Int) {
        this.hour.value = hour.toString()
    }

    fun setMinute(minute: Int) {
        this.minute.value = minute.toString()
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

    fun addAndEditDone(
        callBack: (Any, String) -> Unit,
        loadDeactivate: () -> Unit,
        schedID: String?
    ) {
//        Log.i("Hi", "addDone: $hour $minute $amOrPm")

        if (targetsList.isEmpty() || daysRepeatList.isEmpty()) {
            Toast.makeText(
                MainScreenContext.getContext(),
                "Please select targets and days to repeat",
                Toast.LENGTH_SHORT
            ).show()

            loadDeactivate()
        } else {
            val addSchedObject = AddAndEditScheduleDataClass(
                Targets = targetsList,
                days = daysRepeatList,
                hour = hour.value.toInt(),
                minute = minute.value.toInt(),
                amOrPm = amOrPm.value,
                isActive = true
            )

            if (schedID.isNullOrBlank()) {
                addSchedRepository.addSchedule(addSchedObject,
                    callBack = { boolOrMessage, typeOfOperation ->
                        callBack(boolOrMessage, typeOfOperation)
                    }, loadDeactivate = {
                        loadDeactivate()
                    }
                )
            } else {
                addSchedRepository.updateSchedule(
                    addAndEditScheduleDataClass = addSchedObject,
                    schedID = schedID,
                    callBack = {boolOrMessage, typeOfOperation ->
                        callBack(boolOrMessage, typeOfOperation)
                    },
                    loadDeactivate = {
                        loadDeactivate()
                    })
            }

        }
    }

}