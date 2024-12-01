package com.example.dolpiggery.HealthHistory.Screens.PigHealthHistoryScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.HealthHistory.UIComponents.PigHealthHistoryCard
import com.example.dolpiggery.HealthHistory.ViewModel.PigHealthHistoryViewModel
import com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard.toast
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Orange
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.PigmentGreen
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Poppy
import com.example.dolpiggery.ui.theme.Silver
import com.example.dolpiggery.ui.theme.Snow60
import kotlinx.coroutines.delay
import java.util.Locale


@Composable
fun PigHealthHistoryScreen(pigID: Int) {
    val viewModel: PigHealthHistoryViewModel = viewModel()

    val isListEmpty = rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.addHealthHistory(pigID)
        delay(2000)
        if(viewModel.listOfHealthHistory.isEmpty()) {
            isListEmpty.value = true
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.medical_history),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "Pig $pigID Health History", fontSize = 20.sp)
        }

        if(viewModel.listOfHealthHistory.size > 0) {
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
            ){
                items(viewModel.listOfHealthHistory) {
                    PigHealthHistoryCard(
                        bodyTemp = it.bodyTemp,
                        counter = it.counter,
                        status = it.status,
                        month = it.month,
                        day = it.day,
                        year = it.year,
                        hour = it.hour,
                        minute = it.minute,
                        amOrPM = it.amOrPM
                    )
                    HorizontalDivider()
                }

            }
        }
        else if(isListEmpty.value) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "No health history for this pig yet", fontSize = 18.sp)
            }
        }
        if(viewModel.listOfHealthHistory.isEmpty()) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator(color = PacificCyan5)
            }
        }
    }
}