package com.example.dolpiggery.MainScreen.NavGraph

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.dolpiggery.MainScreen.NavRoutes.Cubicle
import com.example.dolpiggery.MainScreen.NavRoutes.Detail
import com.example.dolpiggery.MainScreen.NavRoutes.Environment
import com.example.dolpiggery.MainScreen.NavRoutes.Settings
import com.example.dolpiggery.MainScreen.Screens.CubiclesScreen.CubicleScreen
import com.example.dolpiggery.MainScreen.Screens.CubiclesScreen.DetailsScreen.DetailScreen
import com.example.dolpiggery.MainScreen.Screens.EnvironmentScreen.EnvironmentScreen
import com.example.dolpiggery.MainScreen.Screens.SettingsScreen.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Cubicle,
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None },
        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
    ) {
        composable<Cubicle> {
            CubicleScreen(navController)
        }
//        composable<Detail> {
//            val args = it.toRoute<Detail>()
//            val cubicleID = args.cubicleID
//            val pigList = args.pigList
//
//            DetailScreen(cubicleID, pigList)
//        }
        composable<Environment> {
            EnvironmentScreen()
        }
        composable<Settings> {
            SettingsScreen()
        }
    }
}