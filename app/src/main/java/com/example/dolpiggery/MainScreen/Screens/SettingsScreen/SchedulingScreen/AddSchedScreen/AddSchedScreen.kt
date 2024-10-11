package com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen.AddSchedScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime.InputTimeTemplate
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime.timeZeroPadding
import com.example.dolpiggery.MainScreen.ViewModel.Scheduling.AddSchedViewModel.AddSchedViewModel

@Composable
fun AddSchedScreen(
    hour: Int,
    minute: Int,
    amOrPm: String,
    schedID: String? = null
) {
    NavigationCurrentPosition.setCurrentNavDestination("AddSched")

    val viewModel: AddSchedViewModel = viewModel()
    viewModel.setHour(hour)
    viewModel.setMinute(minute)
    viewModel.setAmOrPm(amOrPm)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
        ) {
            val txt = if (schedID.isNullOrBlank()) "Add" else "Edit"
            Text(
                text = txt,
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier.weight(0.9f)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    InputTimeTemplate(
                        timeTypeValue = viewModel.hour.value,
                        upperLimit = 12,
                        viewModelSetTime = {
                            viewModel.setHour(it)
                        },
                        timeZeroPadding = {
                            timeZeroPadding(it)
                        }
                    )
                }

                Text(text = ":", fontSize = 35.sp)
                Column {
                    InputTimeTemplate(
                        timeTypeValue = viewModel.minute.value,
                        upperLimit = 59,
                        viewModelSetTime = {
                            viewModel.setMinute(it)
                        },
                        timeZeroPadding = {
                            timeZeroPadding(it)
                        }
                    )
                }
            }
        }
    }
}