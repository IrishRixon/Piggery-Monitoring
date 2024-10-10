package com.example.dolpiggery.MainActivity.Screens.SplashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dolpiggery.MainActivity.NavRoutes.LogIn
import com.example.dolpiggery.MainActivity.Screens.ImageComposables.PigCageImage
import com.example.dolpiggery.ui.theme.PacificCyan5
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    //Invoked the Splash Composable
    Splash()

    /*This will navigate to Login Screen after 2 seconds.
    LaunchedEffect is a coroutine, coroutine is asynchronous
    function means it doesn't block the main thread.
    In this case the LaunchedEffect is needed because to be able to use the
    delay function */

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack() /* Remove the SplashScreen from BackStock
        so that not to go back to it using back button */

        navController.navigate(LogIn) // After 2 seconds it will navigate to Login Screen
    }
}

@Composable
@Preview
fun Splash() {
    //This is the UI of Splash Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PacificCyan5)
    ) {
        PigCageImage(140.dp)
    }
}