package com.example.dolpiggery.Navigation.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.dolpiggery.Navigation.NavRoutes.AddSched
import com.example.dolpiggery.Navigation.NavRoutes.Cubicle
import com.example.dolpiggery.Navigation.NavRoutes.Environment
import com.example.dolpiggery.Navigation.NavRoutes.ManageAccounts
import com.example.dolpiggery.Navigation.NavRoutes.Scheduling
import com.example.dolpiggery.Navigation.NavRoutes.Settings
import com.example.dolpiggery.Pigs.Screens.PigsScreen
import com.example.dolpiggery.Environment.Screens.EnvironmentScreen
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ManageAccountsScreen.ManageAccountsScreen
import com.example.dolpiggery.Settings.Screens.Scheduling.SchedulingScreen.AddSchedScreen.AddSchedScreen
import com.example.dolpiggery.Settings.Screens.Scheduling.SchedulingScreen.SchedulingScreen
import com.example.dolpiggery.Settings.Screens.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Cubicle, // Cubicle Screen is the start of the destination
        contentAlignment = Alignment.Center
    ) {
        composable<Cubicle> {
            PigsScreen(navController)
        }
        composable<Environment> {
            EnvironmentScreen()
        }
        composable<Settings> {
            SettingsScreen(navController)
        }
        composable<Scheduling> {
            SchedulingScreen(navController)
        }
        composable<AddSched> {
            val args = it.toRoute<AddSched>()
            val hour = args.hour
            val minute = args.minute
            val amOrPm = args.amOrPm
            val schedID = args.schedID
            val targets = args.targets
            val daysRepeat = args.daysRepeat

            AddSchedScreen(hour, minute, amOrPm, schedID, targets, daysRepeat, navController)
        }
        composable<ManageAccounts> {
            ManageAccountsScreen(navController)
        }
    }
}