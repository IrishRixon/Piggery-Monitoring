package com.example.dolpiggery

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

const val FOREGROUND_CHANNEL_ID = "foreground_service_channel"

class PersistentForegroundService : Service() {

    override fun onCreate() {
        super.onCreate()
        // Create notification channel for the foreground service
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = createForegroundNotification("App Active", "Listening for notifications")
        startForeground(1, notification) // Starts service in the foreground with a persistent notification
        return START_STICKY // Service is restarted if it gets terminated
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            FOREGROUND_CHANNEL_ID,
            "Foreground Service Channel",
            NotificationManager.IMPORTANCE_LOW // Low importance so it doesn’t draw too much attention
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    private fun createForegroundNotification(title: String, text: String): Notification {
        return NotificationCompat.Builder(this, FOREGROUND_CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(R.drawable.swine_shine)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val restartServiceIntent = Intent("com.example.dolpiggery.RESTART_SERVICE")
        sendBroadcast(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
