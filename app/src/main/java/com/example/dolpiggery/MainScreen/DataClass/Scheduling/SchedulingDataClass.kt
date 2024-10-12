package com.example.dolpiggery.MainScreen.DataClass.Scheduling

data class SchedulingDataClass(
    val schedID: String,
    val targets: List<String>,
    val hour: Int,
    val minute: Int,
    val amOrPm: String,
    val days: List<Int>,
    val isActive: Boolean
)