package com.example.dolpiggery.MainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.dolpiggery.Context
import com.example.dolpiggery.MainActivity.NavGraph.AppNavGraph
import com.example.dolpiggery.ui.theme.DolPiggeryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Context.setContext(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DolPiggeryTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}
