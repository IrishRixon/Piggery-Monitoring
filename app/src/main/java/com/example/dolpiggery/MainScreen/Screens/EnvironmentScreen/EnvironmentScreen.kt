package com.example.dolpiggery.MainScreen.Screens.EnvironmentScreen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainScreen.UIComponents.Graph.BarGraph
import com.example.dolpiggery.MainScreen.ViewModel.Environment.BarGraphViewModel

@Composable
fun EnvironmentScreen() {
    val viewModel: BarGraphViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.addBarGraphData()
        viewModel.addBarDataList()
    }

    BarGraph(
        buwan = viewModel.buwan.value,
        viewModel.barDataList
    )
}