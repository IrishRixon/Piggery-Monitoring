package com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dolpiggery.MainActivity.UIComponents.DefaultOutlineTextField
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.SchedDefaultOutLinedTextField
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.SchedTextButton

@Composable
fun SchedulingScreen() {

    val scroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
//        SchedTextButton()
    }
}