package com.example.dolpiggery.MainScreen.ViewModel

import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Sub
import com.example.dolpiggery.MainScreen.Repository.MainScreenRepository

class MainScreenViewModel: ViewModel() {
    val mainScreenRepository = MainScreenRepository()

    fun subscribed(sub: Sub) {
        mainScreenRepository.subscribe(sub)
    }
}