package com.example.dolpiggery.MainScreen.UIComponents.Scheduling

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.Navigation.NavRoutes.AddSched
import com.example.dolpiggery.Settings.ViewModel.SchedulingViewModel
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun SchedTextButton(
    schedID: String,
    targets: List<Int>,
    hour: Int,
    minute: Int,
    amOrPm: String,
    days: List<Int>,
    isActive: Boolean,
    navController: NavHostController,
) {

    val viewModel: SchedulingViewModel = viewModel()
    val targetsScroll = rememberScrollState()

    TextButton(
        onClick = { navController.navigate(AddSched(hour, minute, amOrPm, schedID, targets, days)) },
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
//        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(10f),
        colors = ButtonColors(
            containerColor = Snow60,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Black
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.8f),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Row(
                modifier = Modifier.horizontalScroll(targetsScroll)
            ) {
                val targetsSorted = targets.sorted()
                val targetsSize = targets.size - 1
                var targetsString = ""
                targetsSorted.forEachIndexed { index, item ->
                    targetsString += "$item"
                    if (index != targetsSize) {
                        targetsString += ", "
                    }
                }
                Text(text = "Pigs $targetsString")
            }

            Row {
                val formattedHour = if(hour < 10) "0$hour" else "$hour"
                val formattedMinute = if(minute < 10) "0$minute" else "$minute"
                Text(
                    text = "$formattedHour : $formattedMinute $amOrPm",
                    fontSize = 30.sp
                )
            }

            Row {
                val daysSorted = days.sorted()
                val daysSize = days.size - 1

                var daysString = ""
                daysSorted.forEachIndexed{ index, item ->
                    daysString += dayIntToDayString(item)
                    if(index != daysSize) {
                        daysString += ", "
                    }
                }
                Text(
                    text = daysString,
                    fontSize = 15.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Switch(
                checked = isActive,
                onCheckedChange = { viewModel.toggleSwitch(it, schedID) },
                modifier = Modifier.size(20.dp),
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Cerulean5,
                    checkedThumbColor = Snow60,
                    uncheckedTrackColor = Color.Gray,
                    uncheckedThumbColor = Snow60
                )
            )
        }
    }
    HorizontalDivider(color = Color.Gray)
}


@Composable
fun SettingsScreenCustomTextButton(
    txt: String,
    goTo: Any,
    navController: NavHostController
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(10f),
        colors = ButtonColors(
            containerColor = Snow60,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Black
        ),
        onClick = { navController.navigate(goTo) }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = txt,
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )
        }
    }
    HorizontalDivider(color = Color.Gray)
}

fun dayIntToDayString(dayInt: Int): String {
    return when(dayInt) {
        0 -> "Sun"
        1 -> "Mon"
        2 -> "Tue"
        3 -> "Wed"
        4 -> "Thu"
        5 -> "Fri"
        6 -> "Sat"
        else -> "Error"
    }
}