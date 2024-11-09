package com.example.dolpiggery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class RestartServiceReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED" ||
            intent.action == "com.example.dolpiggery.RESTART_SERVICE") {

            val serviceIntent = Intent(context, PersistentForegroundService::class.java)
            context.startForegroundService(serviceIntent)
        }
    }
}