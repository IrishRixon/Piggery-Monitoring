package com.example.dolpiggery.Environment.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.Navigation.NavRoutes.Environment
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Graph.BarGraph
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.HumidityCard
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.TempCard
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.WaterConsumpCard
import com.example.dolpiggery.Environment.ViewModel.BarGraph.BarGraphViewModel
import com.example.dolpiggery.Environment.ViewModel.Measurement.MeasurementViewModel
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.Clean
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.Heatindex
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60
import kotlinx.coroutines.delay
import java.util.Locale

@Composable
fun EnvironmentScreen() {
    NavigationCurrentPosition.setCurrentNavDestination("$Environment")
    val viewModel: BarGraphViewModel = viewModel()
    val viewModelMeasurement: MeasurementViewModel = viewModel()

    val scroll = rememberScrollState()

    val measurementIsActive = viewModelMeasurement.measurementIsActive.value
    val waterConsumpIsActive = viewModelMeasurement.waterConsumpIsActive.value

    LaunchedEffect(key1 = Unit) {
        viewModel.addBarGraphData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .background(Snow60)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Log.i("Bar", "Hello")
            if (viewModel.barGraphDataList.isEmpty()) {
                CircularProgressIndicator(color = PacificCyan5)
            } else {
                viewModel.addBarDataList()
                BarGraph(
                    buwan = viewModel.buwan.value,
                    viewModel.barDataList
                )
            }
        }

        LaunchedEffect(key1 = Unit) {
            viewModelMeasurement.addMeasurements()
            delay(1000)
        }

        checkDevicesStatus(measurementIsActive, waterConsumpIsActive)

        var tempValue = "--"
        var humidityValue = "--"
        var waterDailyValue = "--"
        var waterMonthlyValue = "--"
        var heatIndex = "--"

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
        ) {
            if (measurementIsActive) {
                if (viewModelMeasurement.temp.value.isNotEmpty()) {
                    tempValue = viewModelMeasurement.temp.value
                }
                if (viewModelMeasurement.humidity.value.isNotEmpty()) {
                    humidityValue = viewModelMeasurement.humidity.value
                }
                if (viewModelMeasurement.heatIndex.value.isNotEmpty()) {
                    heatIndex = viewModelMeasurement.heatIndex.value
                }
            }
            if (waterConsumpIsActive) {
                if (viewModelMeasurement.waterMonthly.value.isNotEmpty()) {
                    waterMonthlyValue = viewModelMeasurement.waterMonthly.value
                }
                if (viewModelMeasurement.waterDaily.value.isNotEmpty()) {
                    waterDailyValue = viewModelMeasurement.waterDaily.value
                }
            }


            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                TempCard(value = tempValue, isActive = measurementIsActive)
                HumidityCard(value = humidityValue, isActive = measurementIsActive)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                var heatIndexDouble = heatIndex.toDoubleOrNull() ?: 0.0
                var heatIndexFormat = String.format(Locale.getDefault(), "%.1f", heatIndexDouble)
                Heatindex(value = heatIndexFormat, isActive = measurementIsActive)
                Clean(value = viewModelMeasurement.clean.value, isActive = measurementIsActive)
            }



            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                WaterConsumpCard(
                    daily = waterDailyValue,
                    monthly = waterMonthlyValue,
                    isActive = waterConsumpIsActive
                )
            }

        }
    }
}

fun checkDevicesStatus(
    measurementIsActive: Boolean,
    waterConsumpIsActive: Boolean
) {
    if (!measurementIsActive || !waterConsumpIsActive) {
        var txt = ""

        if (!measurementIsActive && !waterConsumpIsActive) {
            txt += "DHT11 and Water flow sensor are not active"
        } else {
            if (!measurementIsActive) {
                txt += "DHT11 is not active"
            }
            if (!waterConsumpIsActive) {
                txt += "Water flow sensor is not active"
            }
        }

        Toast.makeText(MainScreenContext.getContext(), txt, Toast.LENGTH_SHORT).show()
    }
}