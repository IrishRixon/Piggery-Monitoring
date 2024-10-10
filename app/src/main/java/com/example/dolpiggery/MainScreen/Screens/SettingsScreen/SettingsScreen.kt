package com.example.dolpiggery.MainScreen.Screens.SettingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.NavRoutes.ManageAccounts
import com.example.dolpiggery.MainScreen.NavRoutes.Scheduling
import com.example.dolpiggery.MainScreen.NavRoutes.Settings
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.SettingsScreenCustomTextButton
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun SettingsScreen(navController: NavHostController) {
NavigationCurrentPosition.setCurrentNavDestination("$Settings")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SettingsScreenCustomTextButton(
            txt = "Scheduling",
            goTo = Scheduling,
            navController = navController
        )

        SettingsScreenCustomTextButton(
            txt = "Manage Accounts",
            goTo = ManageAccounts,
            navController = navController
        )
    }
}
