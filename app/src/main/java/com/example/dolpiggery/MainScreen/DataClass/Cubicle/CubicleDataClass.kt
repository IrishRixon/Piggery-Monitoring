package com.example.dolpiggery.MainScreen.DataClass.Cubicle

import com.example.dolpiggery.MainScreen.DataClass.Pig.PigDataClass

data class CubicleDataClass(
    val cubicleID: Int,
    val isNeedCleaning: Boolean,
    val sprinklerSwitch: Boolean,
    val pigDataClassList: List<PigDataClass>
)