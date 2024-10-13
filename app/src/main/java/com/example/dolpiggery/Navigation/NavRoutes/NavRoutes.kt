package com.example.dolpiggery.Navigation.NavRoutes

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
object Cubicle

@Serializable
object Environment

@Serializable
object Settings

@Serializable
object Scheduling

@Serializable
data class AddSched (
    val hour: Int = 7,
    val minute: Int = 0,
    val amOrPm: String = "AM",
    val schedID: String? = null,
    val targets: List<Int> = listOf(),
    val daysRepeat: List<Int> = listOf()
)

@Serializable
object ManageAccounts