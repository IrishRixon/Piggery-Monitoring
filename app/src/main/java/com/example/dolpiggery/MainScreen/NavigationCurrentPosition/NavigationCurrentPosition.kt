package com.example.dolpiggery.MainScreen.NavigationCurrentPosition

import androidx.compose.runtime.mutableStateOf

object NavigationCurrentPosition {
    var currentNavPosition = mutableStateOf("")

    fun setCurrentNavDestination(currentNavPosition: String) {
        this.currentNavPosition.value = currentNavPosition
    }
}