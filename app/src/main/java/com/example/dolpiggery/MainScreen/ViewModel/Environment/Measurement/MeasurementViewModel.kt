package com.example.dolpiggery.MainScreen.ViewModel.Environment.Measurement

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.Repository.Environment.Measurement.MeasurementRepository

class MeasurementViewModel: ViewModel() {
    val measurementRepository = MeasurementRepository()

    val temp = mutableStateOf("")
    val humidity = mutableStateOf("")
    val waterDaily = mutableStateOf("")
    val waterMonthly = mutableStateOf("")

    fun addMeasurements() {
        measurementRepository.addMeasurements(
            onTempChange = {
                temp.value = it
            },
            onHumidityChange = {
                humidity.value = it
            },
            onWaterDailyChange = {
                waterDaily.value = it
            },
            onWaterMonthlyChange = {
                waterMonthly.value = it
            }
        )
    }
}