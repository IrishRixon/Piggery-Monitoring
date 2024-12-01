package com.example.dolpiggery.HealthHistory.Repository

import android.util.Log
import com.example.dolpiggery.HealthHistory.DataClass.PigHealthHistoryDataClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PigHealthHistoryRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference("HealthHistory")

    fun addPigHealthHistory(pigID: Int, onDatachanged: (List<PigHealthHistoryDataClass>) -> Unit) {
        databaseRef.child("Pig_$pigID").addValueEventListener( object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var bodyTemp: String
                var counter: Int
                var status: String
                var month: Int
                var day: Int
                var year: Int
                var hour: Int
                var minute: Int
                var amOrPM: String

                val listOfEntry = mutableListOf<PigHealthHistoryDataClass>()

                if(snapshot.exists()) {
                    for(entry in snapshot.children) {
                        Log.i("arisoh", "onDataChange: $entry")

                        bodyTemp = entry.child("BodyTemp").value.toString()
                        counter = entry.child("counter").value.toString().toInt()
                        status = entry.child("status").value.toString()
                        month = entry.child("month").value.toString().toInt()
                        day = entry.child("day").value.toString().toInt()
                        year = entry.child("year").value.toString().toInt()
                        hour = entry.child("hour").value.toString().toInt()
                        minute = entry.child("minute").value.toString().toInt()
                        amOrPM = entry.child("amOrPm").value.toString()

                        listOfEntry.add(PigHealthHistoryDataClass(bodyTemp, counter, status, month, day, year, hour, minute, amOrPM))
                    }

                    onDatachanged(listOfEntry)
                }
                else return
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}