package com.example.piggery.MainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.piggery.MainActivity.NavGraph.AppNavGraph
import com.example.piggery.ui.theme.PiggeryTheme
import com.example.piggery.ui.theme.Snow60

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PiggeryTheme {
                val navController = rememberNavController()

                AppNavGraph(navController = navController)
            }
        }
    }
}
