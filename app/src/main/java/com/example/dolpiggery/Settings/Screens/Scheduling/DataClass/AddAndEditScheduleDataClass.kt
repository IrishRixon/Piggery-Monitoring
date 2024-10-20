package com.example.dolpiggery.Settings.Screens.Scheduling.DataClass

data class AddAndEditScheduleDataClass(
    val Targets: List<Int>,
    val days: List<Int>,
    val hour: Int,
    val minute: Int,
    val amOrPm: String,
    val isActive: Boolean
)