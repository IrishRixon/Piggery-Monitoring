package com.example.dolpiggery.MainActivity.NavGraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.*
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dolpiggery.MainActivity.NavRoutes.LogIn
import com.example.dolpiggery.MainActivity.NavRoutes.SplashScreen
import com.example.dolpiggery.MainActivity.Screens.LoginScreen.LoginScreen
import com.example.dolpiggery.MainActivity.Screens.SplashScreen.TransitionToLogin

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {
        composable<SplashScreen> {
            TransitionToLogin(navController)
        }
        composable<LogIn> {
            LoginScreen()
        }
    }
}