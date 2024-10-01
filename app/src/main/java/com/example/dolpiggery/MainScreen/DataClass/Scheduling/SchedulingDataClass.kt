package com.example.dolpiggery.MainScreen.DataClass.Scheduling

data class  SchedulingDataClass(
    val cubicleID: Int,
    val hour: Int,
    val minute: Int,
    val amOrPm: String,
    val days: List<String>,
    val isActive: Boolean
)