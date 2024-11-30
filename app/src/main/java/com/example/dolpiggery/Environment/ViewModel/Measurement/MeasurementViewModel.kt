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
    val clean = mutableStateOf(true)
    val heatIndex = mutableStateOf("")
    val measurementIsActive = mutableStateOf(true)
    val waterConsumpIsActive = mutableStateOf(true)

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
            },
            onCleanChanged = {
                clean.value = it
            },
            onHeatIndexChanged = {
                heatIndex.value = it
            },
            onMeasurementIsActiveChanged = {
                measurementIsActive.value = it
            },
            onWaterConsumpIsActiveChanged = {
                waterConsumpIsActive.value = it
            }
        )
    }
}