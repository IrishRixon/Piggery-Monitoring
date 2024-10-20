package com.example.dolpiggery.Settings.Screens.Scheduling.DataClass

data class SchedulingDataClass(
    val schedID: String,
    val targets: List<Int>,
    val hour: Int,
    val minute: Int,
    val amOrPm: String,
    val days: List<Int>,
    val isActive: Boolean
)