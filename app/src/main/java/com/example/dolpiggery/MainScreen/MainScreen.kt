package com.example.dolpiggery.MainScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.dolpiggery.MainScreen.DataClass.Sub
import com.example.dolpiggery.MainScreen.Repository.MainScreenRepository
import com.example.dolpiggery.Navigation.NavGraph.AppNavGraph
import com.example.dolpiggery.MainScreen.UIComponents.NavigationBar.CreateNavBar
import com.example.dolpiggery.MainScreen.UIComponents.NavigationBar.CreateTopBar
import com.example.dolpiggery.MainScreen.ViewModel.MainScreenViewModel
import com.example.dolpiggery.PersistentForegroundService
import com.example.dolpiggery.ui.theme.DolPiggeryTheme
import com.example.dolpiggery.ui.theme.Snow60
import com.google.firebase.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.messaging.messaging

class MainScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        MainScreenContext.setContext(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val intent = Intent()
            val packageName = packageName
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager


            Intent(this, PersistentForegroundService::class.java).also { intent ->
                startForegroundService(intent)
            }

            DolPiggeryTheme {
                //Initialize the navController that will be used to control the navigation
                val navController = rememberNavController()
                val viewModel: MainScreenViewModel = viewModel()
                getTokenAndSubscribe(viewModel)

                viewModel.initialized()


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

    private fun getTokenAndSubscribe(viewModel: MainScreenViewModel) {

        Firebase.messaging.token.addOnCompleteListener{
            if(!it.isSuccessful) {
                Log.w("Yowsi", "getTokenAndSubscribe: ${it.exception}")
                return@addOnCompleteListener
            }

            val token = it.result
            val sub = Sub(token)
            Log.i("Yowsi", "Token: $token")

            tokenSubscribe()
            viewModel.subscribed(sub)
        }
    }

    private fun tokenSubscribe() {
        FirebaseMessaging.getInstance().subscribeToTopic("set").addOnCompleteListener {
            if (!it.isSuccessful) {
                Log.w("FCM", "Fetching FCM registration token failed", it.exception)
                return@addOnCompleteListener
            }

            Log.i("Yowsi", "tokenSubscribe: Success")
        }
    }
}