package com.example.dolpiggery.MainScreen.DataClass.Cubicle

import com.example.dolpiggery.MainScreen.DataClass.Pig

data class Cubicle(
    val cubicleID: Int,
    val isNeedCleaning: Boolean,
    val sprinklerSwitch: Boolean,
    val pigList: List<Pig>
)