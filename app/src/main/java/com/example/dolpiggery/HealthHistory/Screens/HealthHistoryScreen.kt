package com.example.dolpiggery.HealthHistory.Screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.HealthHistory.UIComponents.HealthHistoryTextButton
import com.example.dolpiggery.HealthHistory.ViewModel.HealthHistoryViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5

@Composable
fun HealthHistoryScreen(navController: NavHostController) {
    val viewModel: HealthHistoryViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.addPig()
        Log.i("Yowsi", "HealthHistoryScreen: ${viewModel.listOfPigs}")

    }

    if(viewModel.listOfPigs.isEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            CircularProgressIndicator(color = PacificCyan5)
        }
    }
    else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(viewModel.listOfPigs) {
                HealthHistoryTextButton(
                    navController = navController,
                    pigID = it.pigID
                )
            }
        }
    }

    Log.i("Yowsi", "HealthHistoryScreen: ${viewModel.listOfPigs}")

}