package com.example.dolpiggery.MainScreen.NavRoutes

import com.example.dolpiggery.MainScreen.DataClass.Pig.PigDataClass
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