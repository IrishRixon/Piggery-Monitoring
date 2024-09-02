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
import com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard.CubicleCard
import com.example.dolpiggery.MainScreen.ViewModel.Cubicles.CubiclesViewModel
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun CubicleScreen() {
    val viewModel: CubiclesViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Snow60)
            .padding(16.dp)
    ) {
        LaunchedEffect(key1 = Unit) {
            viewModel.addCubicles()
//            Log.i("Hey", "${viewModel.cubicleList.size}")
        }

        if(viewModel.cubicleList.isEmpty()) {
            Text(text = "Loading ... ", fontSize = 20.sp)
        }
        else {
            LazyColumn {
                items(viewModel.cubicleList) {
                    CubicleCard(
                        cubicleID = it.cubicleID,
                        sprinklerSwitch = it.sprinklerSwitch,
                        broomTint = it.isNeedCleaning
                    )
                }
            }
        }
    }

//    CubicleCard(1)
}