package com.example.piggery.MainActivity.Screens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
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
import com.example.piggery.MainActivity.NavRoutes.LogIn
import com.example.piggery.MainActivity.Screens.ImageComposables.PigCageImage
import com.example.piggery.R
import com.example.piggery.ui.theme.LightBlue30
import com.example.piggery.ui.theme.PacificCyan5
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