package com.example.dolpiggery.Settings.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dolpiggery.Navigation.NavRoutes.ManageAccounts
import com.example.dolpiggery.Navigation.NavRoutes.Scheduling
import com.example.dolpiggery.Navigation.NavRoutes.Settings
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.SettingsScreenCustomTextButton

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
