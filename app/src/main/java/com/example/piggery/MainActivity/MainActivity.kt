package com.example.piggery.MainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.piggery.MainActivity.NavGraph.AppNavGraph
import com.example.piggery.R
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

    @Composable
    fun Icon() {
        Icon(painter = painterResource(id = R.drawable.non_visible), contentDescription = null)
    }
}
