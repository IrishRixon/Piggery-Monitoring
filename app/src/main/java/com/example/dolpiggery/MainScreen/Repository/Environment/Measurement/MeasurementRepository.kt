package com.example.dolpiggery.MainScreen.Repository.Environment.Measurement

import android.util.Log
import android.widget.Toast
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MeasurementRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference("Environment")

    fun addMeasurements(
        onTempChange: (String) -> Unit,
        onHumidityChange: (String) -> Unit,
        onWaterDailyChange: (String) -> Unit,
        onWaterMonthlyChange: (String) -> Unit
    ) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    val tempRef = snapshot.child("Temperature")
                    val humidityRef = snapshot.child("Humidity")
                    val waterDailyRef = snapshot.child("Water_consump").child("daily").child("value");
                    val waterMonthlyRef = snapshot.child("Water_consump").child("weekly").child("value")

                    onTempChange(tempRef.value.toString())
                    onHumidityChange(humidityRef.value.toString())
                    onWaterDailyChange(waterDailyRef.value.toString())
                    onWaterMonthlyChange(waterMonthlyRef.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(MainScreenContext.getContext(), "$error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}