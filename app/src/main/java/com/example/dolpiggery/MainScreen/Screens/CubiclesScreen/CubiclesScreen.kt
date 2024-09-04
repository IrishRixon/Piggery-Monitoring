package com.example.dolpiggery.MainScreen.Screens.CubiclesScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.NavRoutes.Detail
import com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard.CubicleCard
import com.example.dolpiggery.MainScreen.ViewModel.Cubicles.CubiclesViewModel
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun CubicleScreen(navController: NavHostController) {
    val viewModel: CubiclesViewModel = viewModel()
    LaunchedEffect(key1 = Unit) {
        viewModel.addCubicles()
    }

    if (viewModel.cubicleList.isEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Loading ... ", fontSize = 20.sp)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(viewModel.cubicleList) {
                CubicleCard(
                    cubicleID = it.cubicleID,
                    sprinklerSwitch = it.sprinklerSwitch,
                    broomTint = it.isNeedCleaning,
                    onItemClick = {
                        navController.navigate(
                            Detail(
                                cubicleID = it.cubicleID,
                            )
                        )
                    }
                )
            }
        }
    }
}