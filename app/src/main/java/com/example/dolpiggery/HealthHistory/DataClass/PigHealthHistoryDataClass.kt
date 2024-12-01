package com.example.dolpiggery.HealthHistory.DataClass

data class PigHealthHistoryDataClass(
    val bodyTemp: String,
    val counter: Int,
    val status: String,
    val month: Int,
    val day: Int,
    val year: Int,
    val hour: Int,
    val minute: Int,
    val amOrPM: String
)
