package com.example.dolpiggery.Settings.Screens.Scheduling.SchedulingScreen.AddSchedScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.BridgeClass.PigsTOAddSched
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime.AmOrPmUi
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime.InputTimeTemplate
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime.timeZeroPadding
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.Repeat.DayRepeatButton
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.Targets.TargetButton
import com.example.dolpiggery.Settings.Screens.Scheduling.ViewModel.AddSchedViewModel.AddSchedViewModel
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun AddSchedScreen(
    hour: Int,
    minute: Int,
    amOrPm: String,
    schedID: String? = null,
    targets: List<Int>,
    daysRepeat: List<Int>,
    navController: NavHostController
) {
    NavigationCurrentPosition.setCurrentNavDestination("AddSched")
    val targetsScroll = rememberScrollState()
    val isLoading = rememberSaveable {
        mutableStateOf(false)
    }

//    Log.i("Hi", "I recomposed")
    val viewModel: AddSchedViewModel = viewModel()

    if (viewModel.hour.value.isEmpty() &&
        viewModel.minute.value.isEmpty() &&
        viewModel.amOrPm.value.isEmpty() &&
        viewModel.daysRepeatList.isEmpty() &&
        viewModel.targetsList.isEmpty()
    ) {
        viewModel.setHour(hour)
        viewModel.setMinute(minute)
        viewModel.setAmOrPm(amOrPm)
        viewModel.setDaysRepeat(daysRepeat)
        viewModel.setTargets(targets)
    }

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
            modifier = Modifier.weight(0.85f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    InputTimeTemplate(
                        timeTypeValue = viewModel.hour.value,
                        upperLimit = 12,
                        lowerLimit = 1,
                        viewModelSetTime = {
                            viewModel.setHour(it)
                            Log.i("Hi", "hourView: ${viewModel.hour.value}")
                        },
                        zeroPadding = {
                            timeZeroPadding(it, "Hour")
                        }
                    )
                }

                Text(text = ":", fontSize = 35.sp)

                Column {
                    InputTimeTemplate(
                        timeTypeValue = viewModel.minute.value,
                        upperLimit = 59,
                        lowerLimit = 0,
                        viewModelSetTime = {
                            viewModel.setMinute(it)
                        },
                        zeroPadding = {
                            timeZeroPadding(it, "Minute")
                        }
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AmOrPmUi(isUp = true, valState = viewModel.amOrPm.value) {
                        viewModel.setAmOrPm(it)
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column {
                Row(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "Repeat", fontSize = 15.sp)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (i in 0..6) {
                        DayRepeatButton(viewModel = viewModel, day = i)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column {
                Row(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "Target Pigs", fontSize = 15.sp)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                        .horizontalScroll(targetsScroll)
                ) {
                    PigsTOAddSched.getPigViewModel()?.pigsList?.forEachIndexed { index, item ->
                        TargetButton(viewModel = viewModel, target = index + 1)
                    }
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Button(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.7f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Platinum,
                    contentColor = Cerulean5
                )
            ) {
                Text(text = "Cancel")
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Button(
                onClick = {
                    isLoading.value = true

                        viewModel.addAndEditDone(
                            callBack = { boolOrMessage, typeOfOperation ->
                                if (boolOrMessage is Boolean) {
                                    if (boolOrMessage) {
                                        navController.popBackStack()
                                        Toast.makeText(
                                            MainScreenContext.getContext(),
                                            if(typeOfOperation == "update") "Successfully updated" else "Successfully added",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    if (boolOrMessage is String) {
                                        Toast.makeText(
                                            MainScreenContext.getContext(),
                                            boolOrMessage,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            },
                            loadDeactivate = {
                                isLoading.value = false
                            },
                            schedID = schedID
                        )

                },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.7f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cerulean5,
                    contentColor = Snow60
                )
            ) {
                if (isLoading.value) {
                    CircularProgressIndicator(color = Snow60)
                } else {
                    Text(text = "Done")
                }
            }
        }
    }
}