package com.example.dolpiggery.MainScreen.NavRoutes

import com.example.dolpiggery.MainScreen.DataClass.Cubicle.Pig.PigDataClass
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
object Cubicle

@Serializable
object Environment

@Serializable
object Settings

@Serializable
data class Detail (
    val cubicleID: Int
)

@Serializable
object Scheduling

@Serializable
data class AddSched (
    val hour: Int = 7,
    val minute: Int = 0,
    val amOrPm: String = "AM",
    val schedID: String? = null
)

@Serializable
object ManageAccounts