package com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen.AddSchedScreen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.substring
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSchedScreen.AddSchedOutlinedButton
import com.example.dolpiggery.MainScreen.ViewModel.Scheduling.AddSchedViewModel.AddSchedViewModel
import com.example.dolpiggery.ui.theme.Snow60

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

    var hourState by remember { mutableStateOf(viewModel.hour.value) }

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
            Row {
                Column {
                    AddSchedOutlinedButton(isUp = true) {
                        val count = if(hourState.toInt() > 12) 1 else hourState.toInt() + 1
                        hourState = count.toString()
                        viewModel.setHour(hourState.toInt())
                    }

                    OutlinedTextField(
                        value = getHourDisplayedValue(hourState),
                        onValueChange =
                        {
                            val hourValue = if (it.isNotEmpty()) it.toInt() else 0
                            hourState = if(hourValue > 12) (hourValue % 10).toString() else hourValue.toString()
                        },
                        colors = OutlinedTextFieldDefaults.colors(),
                        modifier = Modifier.width(150.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        textStyle = TextStyle(
                            fontSize = 35.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

fun getHourDisplayedValue(value: String): String {
    Log.i("Hi", value)
    return if (value.toInt() < 10) {
        "0$value"
    } else {
        value
    }
}