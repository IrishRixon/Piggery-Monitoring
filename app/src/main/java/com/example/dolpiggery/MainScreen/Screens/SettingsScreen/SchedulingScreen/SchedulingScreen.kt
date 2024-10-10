package com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dolpiggery.MainScreen.NavRoutes.Scheduling
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.SchedTextButton
import com.example.dolpiggery.MainScreen.ViewModel.Scheduling.SchedulingViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5

@Composable
fun SchedulingScreen(navController: NavController) {
    NavigationCurrentPosition.setCurrentNavDestination("$Scheduling")

    val viewModel: SchedulingViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.addScheduleList()
    }

    if (viewModel.scheduleList.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
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
            items(viewModel.scheduleList) {
                SchedTextButton(
                    schedID = it.schedID,
                    targets = it.targets,
                    days = it.days,
                    hour = it.hour,
                    minute = it.minute,
                    amOrPm = it.amOrPm,
                    isActive = it.isActive
                )
            }
        }
    }
}