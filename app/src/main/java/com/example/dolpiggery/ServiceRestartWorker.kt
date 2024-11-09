package com.example.dolpiggery

import android.content.Context
import android.content.Intent
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.util.Log

class ServiceRestartWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.i("ServiceRestartWorker", "Checking if service is running")

        // Start the PersistentForegroundService if it's not already running
        val serviceIntent = Intent(applicationContext, PersistentForegroundService::class.java)
        applicationContext.startForegroundService(serviceIntent)

        // Indicate that the work finished successfully
        return Result.success()
    }
}
