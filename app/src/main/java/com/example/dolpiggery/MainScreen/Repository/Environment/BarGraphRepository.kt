package com.example.dolpiggery.MainScreen.Repository.Environment

import android.util.Log
import android.widget.Toast
import com.example.dolpiggery.MainScreen.DataClass.Environment.BarGraph.BarGraphDataClass
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.LocalDate

class BarGraphRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference().child("Temperature_History")

    fun addBarGraphData( addBuwan: (String) -> Unit, onDataChanged: (list: List<BarGraphDataClass>) -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var araw = 0
                var temp = 0

                val list = mutableListOf<BarGraphDataClass>()
                if(snapshot.exists()) {
                    for (month in snapshot.children) {
                        if(month.key.equals(LocalDate.now().month.toString(), true)) {
//                            Log.i("Hey", "helo")
                            val buwan = month.key.toString()

                            for(day in month.children) {
                                araw = day.key.toString().toInt()
                                if(day.child("temp").exists()) {
                                    temp = day.child("temp").value.toString().toInt()
                                }

                                list.add(BarGraphDataClass(araw, temp))
                            }

                            onDataChanged(list)
                            addBuwan(buwan)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(MainScreenContext.getContext(), "$error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}