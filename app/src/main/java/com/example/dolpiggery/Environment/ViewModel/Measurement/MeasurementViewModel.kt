package com.example.dolpiggery.Environment.ViewModel.Measurement

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.Environment.Repository.Measurement.MeasurementRepository

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