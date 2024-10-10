package com.example.dolpiggery.MainScreen.Screens.CubiclesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.MainScreen.NavRoutes.Cubicle
import com.example.dolpiggery.MainScreen.NavRoutes.Detail
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard.CubicleCard
import com.example.dolpiggery.MainScreen.ViewModel.Cubicles.CubiclesViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun CubicleScreen(navController: NavHostController) {
    NavigationCurrentPosition.setCurrentNavDestination("$Cubicle")
    val viewModel: CubiclesViewModel = viewModel()
    LaunchedEffect(key1 = Unit) {
        viewModel.addCubicles()
    }

    /* Display the Loading text while getting the list of cubicles.
    * else recompose the composable and display the list of cubicles*/
    if (viewModel.cubicleList.isEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = PacificCyan5)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            // Iterate the cubicleList and invoke the CubicleCard Composables with the needed arguments
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