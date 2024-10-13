package com.example.dolpiggery.Navigation.NavigationCurrentPosition

import androidx.compose.runtime.mutableStateOf

object NavigationCurrentPosition {
    var currentNavPosition = mutableStateOf("")

    fun setCurrentNavDestination(currentNavPosition: String) {
        NavigationCurrentPosition.currentNavPosition.value = currentNavPosition
    }
}