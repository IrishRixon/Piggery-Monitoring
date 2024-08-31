package com.example.dolpiggery.MainActivity.Screens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dolpiggery.MainActivity.NavRoutes.LogIn
import com.example.dolpiggery.MainActivity.Screens.ImageComposables.PigCageImage
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.LightBlue30
import com.example.dolpiggery.ui.theme.PacificCyan5
import kotlinx.coroutines.delay

@Composable
fun TransitionToLogin(navController: NavController) {
    Splash()

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(LogIn)
    }
}

@Composable
@Preview
fun Splash() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PacificCyan5)
    ) {
        PigCageImage(140.dp)
    }
}