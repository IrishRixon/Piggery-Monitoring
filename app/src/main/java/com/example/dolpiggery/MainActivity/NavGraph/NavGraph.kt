package com.example.dolpiggery.MainActivity.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dolpiggery.MainActivity.NavRoutes.LogIn
import com.example.dolpiggery.MainActivity.NavRoutes.SplashScreen
import com.example.dolpiggery.MainActivity.Screens.LoginScreen.LoginScreen
import com.example.dolpiggery.MainActivity.Screens.SplashScreen.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    /* NavHost is used to place the hierarchy of
    the composabales of the navigation */

    NavHost(
        navController = navController, // navController is used to control the navigation
        startDestination = SplashScreen // Starts with the SplashScreen
    ) {
        /* <> Inside this is an object that is used by the navigation lib as a route.
        if the destination goes to this object then the composable is called */
        composable<SplashScreen> {
            SplashScreen(navController) // <- This is the composable mentioned above
        }
        composable<LogIn> {
            LoginScreen()
        }
    }
}