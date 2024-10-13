package com.example.dolpiggery.Pigs.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.BridgeClass.PigsTOAddSched
import com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard.PigCard
import com.example.dolpiggery.Navigation.NavRoutes.Cubicle
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.Pigs.ViewModel.Cubicles.CubiclesViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5

@Composable
fun PigsScreen(navController: NavHostController) {
    NavigationCurrentPosition.setCurrentNavDestination("$Cubicle")
    val viewModel: CubiclesViewModel = viewModel()
    PigsTOAddSched.setPigViewModel(viewModel)

    LaunchedEffect(key1 = Unit) {
        viewModel.addCubicles()
    }

    /* Display the Loading text while getting the list of cubicles.
    * else recompose the composable and display the list of cubicles*/
    if (viewModel.pigsList.isEmpty()) {
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
            items(viewModel.pigsList) {
                PigCard(
                    pigID = it.pigID,
                    sprinklerSwitch = it.valveSwitch,
                    pigBodyTemp = it.bodyTemp
                )
            }
        }
    }
}