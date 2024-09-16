package com.example.dolpiggery.MainScreen.Screens.EnvironmentScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainScreen.UIComponents.Graph.BarGraph
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.HumidityCard
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.TempCard
import com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards.WaterConsumpCard
import com.example.dolpiggery.MainScreen.ViewModel.Environment.BarGraph.BarGraphViewModel
import com.example.dolpiggery.MainScreen.ViewModel.Environment.Measurement.MeasurementViewModel
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun EnvironmentScreen() {
    val viewModel: BarGraphViewModel = viewModel()
    val viewModelMeasurement: MeasurementViewModel = viewModel()

    val scroll = rememberScrollState()

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
                Text(text = "Loading ... ", fontSize = 20.sp)
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
        }

        var tempValue = "--"
        var humidityValue = "--"
        var waterDailyValue = "--"
        var waterMonthlyValue = "--"

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
        ) {
            if (viewModelMeasurement.temp.value.isNotEmpty()) {
                tempValue = viewModelMeasurement.temp.value
            }
            if (viewModelMeasurement.humidity.value.isNotEmpty()) {
                humidityValue = viewModelMeasurement.humidity.value
            }
            if (viewModelMeasurement.waterDaily.value.isNotEmpty()) {
                waterDailyValue = viewModelMeasurement.waterDaily.value
            }
            if (viewModelMeasurement.waterMonthly.value.isNotEmpty()) {
                waterMonthlyValue = viewModelMeasurement.waterMonthly.value
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                TempCard(value = tempValue)
                HumidityCard(value = humidityValue)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                WaterConsumpCard(daily = waterDailyValue, monthly = waterMonthlyValue)
            }

        }
    }
}