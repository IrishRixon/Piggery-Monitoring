package com.example.dolpiggery.MainActivity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.work.PeriodicWorkRequestBuilder
import com.example.dolpiggery.MainActivity.NavGraph.AppNavGraph
import com.example.dolpiggery.PersistentForegroundService
import com.example.dolpiggery.ServiceRestartWorker
import com.example.dolpiggery.ui.theme.DolPiggeryTheme
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.firebase.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.messaging.messaging
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        MainActivityContext.setContext(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            scheduleServiceRestartWorker()
            getToken()
            topicSubscribe()

            val intent = Intent()
            val packageName = packageName
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                intent.data = Uri.parse("package:$packageName")
                startActivity(intent)
            }

            Intent(this, PersistentForegroundService::class.java).also { intent ->
                startForegroundService(intent)

                DolPiggeryTheme {
                    //Initialize the navController that will be used to control the navigation
                    val navController = rememberNavController()

                    //Invoked the AppNavGraph composable and passed the navController as an argument
                    AppNavGraph(navController = navController)
                }
            }
        }
    }

    private fun scheduleServiceRestartWorker() {
        // Define a periodic work request to check and restart the service every 15 minutes
        val workRequest = PeriodicWorkRequestBuilder<ServiceRestartWorker>(15, TimeUnit.MINUTES)
            .build()

        // Schedule the work using WorkManager, replacing any existing request with the same name
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "ServiceRestartWorker",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }

    private fun topicSubscribe() {
        Firebase.messaging.subscribeToTopic("best").addOnCompleteListener{
            if(it.isSuccessful) {
                Toast.makeText(MainActivityContext.getContext(), "Successfully subscribed to set", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(MainActivityContext.getContext(), "Failed to subscribed to piggery", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                Log.w("FCM", "Fetching FCM registration token failed", it.exception)
                return@addOnCompleteListener
            }

            val token = it.result
            Log.i("Yowsi", "Token: $token")
        }
    }
}
