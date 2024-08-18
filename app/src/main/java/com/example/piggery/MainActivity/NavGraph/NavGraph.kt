package com.example.piggery.MainActivity.NavGraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.*
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.piggery.MainActivity.NavRoutes.LogIn
import com.example.piggery.MainActivity.NavRoutes.SplashScreen
import com.example.piggery.MainActivity.Screens.LoginScreen.LoginScreen
import com.example.piggery.MainActivity.Screens.SplashScreen.TransitionToLogin

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