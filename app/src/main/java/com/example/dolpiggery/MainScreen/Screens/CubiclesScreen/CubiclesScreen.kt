package com.example.dolpiggery.MainScreen.Screens.CubiclesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainScreen.ViewModel.Cubicles.CubiclesViewModel

@Composable
fun CubicleScreen() {
    val viewModel: CubiclesViewModel = viewModel()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LaunchedEffect(key1 = Unit) {
            viewModel.setBPM()
            viewModel.setBodyTemp()
        }

        Text(text = "BPM: ${viewModel.bpm.value}", fontSize = 30.sp)
        Text(text = "Body temp: ${viewModel.bodyTemp.value}", fontSize = 30.sp)
    }
}