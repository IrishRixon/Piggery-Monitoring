package com.example.dolpiggery.MainScreen.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.dolpiggery.MainScreen.NavRoutes.AddSched
import com.example.dolpiggery.MainScreen.NavRoutes.Cubicle
import com.example.dolpiggery.MainScreen.NavRoutes.Detail
import com.example.dolpiggery.MainScreen.NavRoutes.Environment
import com.example.dolpiggery.MainScreen.NavRoutes.ManageAccounts
import com.example.dolpiggery.MainScreen.NavRoutes.Scheduling
import com.example.dolpiggery.MainScreen.NavRoutes.Settings
import com.example.dolpiggery.MainScreen.Screens.CubiclesScreen.CubicleScreen
import com.example.dolpiggery.MainScreen.Screens.CubiclesScreen.DetailsScreen.DetailScreen
import com.example.dolpiggery.MainScreen.Screens.EnvironmentScreen.EnvironmentScreen
import com.example.dolpiggery.MainScreen.Screens.SettingsScreen.ManageAccountsScreen.ManageAccountsScreen
import com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen.AddSchedScreen.AddSchedScreen
import com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SchedulingScreen.SchedulingScreen
import com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Cubicle, // Cubicle Screen is the start of the destination
        contentAlignment = Alignment.Center
    ) {
        composable<Cubicle> {
            CubicleScreen(navController)
        }
        composable<Detail> {
            val args = it.toRoute<Detail>()
            val cubicleID = args.cubicleID

            DetailScreen(cubicleID)
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

            AddSchedScreen(hour, minute, amOrPm, schedID)
        }
        composable<ManageAccounts> {
            ManageAccountsScreen()
        }
    }
}