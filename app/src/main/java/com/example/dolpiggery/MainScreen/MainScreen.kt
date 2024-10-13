package com.example.dolpiggery.MainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.dolpiggery.Navigation.NavGraph.AppNavGraph
import com.example.dolpiggery.MainScreen.UIComponents.NavigationBar.CreateNavBar
import com.example.dolpiggery.MainScreen.UIComponents.NavigationBar.CreateTopBar
import com.example.dolpiggery.ui.theme.DolPiggeryTheme
import com.example.dolpiggery.ui.theme.Snow60

class MainScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        MainScreenContext.setContext(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DolPiggeryTheme {
                //Initialize the navController that will be used to control the navigation
                val navController = rememberNavController()


                // Scaffold is used to create top bar and bottom bar
                Scaffold(
                    topBar = {
                        // TopAppBar composable is used to create a simple top app bar
                        CreateTopBar(navController)
                    },
                    containerColor = Snow60,
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        CreateNavBar(navController = navController)
                    }
                ) { innerPadding ->
                    /* This is the content of the Scaffold,
                    The innerPadding is a must to pass as an argument to padding.
                    This is where the content of the screens will be placed */

                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        //Used to control the navigation of screens
                        AppNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}