package com.example.dolpiggery

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.dolpiggery.MainActivity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val CHANNEL_ID = "notification_channelll"
const val CHANNEL_NAME = "com.example.dolpiggery"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.i("hello", "${message}")
        message.notification?.let {
            Log.i("hello", "dito")
            generateNotification(it.title ?: "Default Title", it.body ?: "Default Body")
        }

        // Handle data payload
        if (message.data.isNotEmpty()) {
            Log.i("hello", "dito2")
            val title = message.data["title"] ?: "Default Title"
            val body = message.data["body"] ?: "Default Body"
            generateNotification(title, body)
        }
    }

    fun generateNotification(title: String, message: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pending = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, R.string.default_notification_channel_id.toString())
            .setSmallIcon(R.drawable.swine_shine)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pending)

        builder = builder.setContent(getRemoteView(title, message))
//        startForegroundService(intent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(R.string.default_notification_channel_id.toString(), CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(System.currentTimeMillis().toInt(), builder.build())
    }

    fun getRemoteView(title: String, message: String): RemoteViews? {
        val remoteView = RemoteViews("com.example.dolpiggery", R.layout.layout)

        remoteView.setTextViewText(R.id.title, title)
        remoteView.setTextViewText(R.id.message, message)
        remoteView.setImageViewResource(R.id.appLogo, R.drawable.swine_shine)

        return remoteView
    }
}