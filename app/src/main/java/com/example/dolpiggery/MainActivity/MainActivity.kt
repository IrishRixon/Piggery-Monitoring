package com.example.dolpiggery.MainActivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.dolpiggery.MainActivity.NavGraph.AppNavGraph
import com.example.dolpiggery.ui.theme.DolPiggeryTheme
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        MainActivityContext.setContext(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            getToken()
            DolPiggeryTheme {
                //Initialize the navController that will be used to control the navigation
                val navController = rememberNavController()

                //Invoked the AppNavGraph composable and passed the navController as an argument
                AppNavGraph(navController = navController)
            }
        }
    }

    private fun getToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful) {
                val token = it.result
                Log.i("Yowsi", "getToken: $token")
            }
        }
    }
}
