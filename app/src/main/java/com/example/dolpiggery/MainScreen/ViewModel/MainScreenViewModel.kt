package com.example.dolpiggery.MainScreen.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.DataClass.Sub
import com.example.dolpiggery.MainScreen.Repository.InitializeRepository
import com.example.dolpiggery.MainScreen.Repository.MainScreenRepository

class MainScreenViewModel: ViewModel() {
    val mainScreenRepository = MainScreenRepository()
    val initializeRepository = InitializeRepository()

    fun subscribed(sub: Sub) {
        mainScreenRepository.subscribe(sub)
    }

    fun initialized() {
        Log.i("Yowsi", "onCreate: Mainscreen")
        initializeRepository.initialize()
    }
}