package com.example.dolpiggery.Settings.Repository

import android.util.Log
import android.widget.Toast
import com.example.dolpiggery.Settings.DataClass.Scheduling.SchedulingDataClass
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SchedulingRepository {

    val databaseRef = FirebaseDatabase.getInstance().getReference()

    /*Question to self how you come up with the lambda logic
    * 1. saan iinvoke yung lambda? ans. sa loob ng function
    * 2. ano gagawin ng lambda na nainvoked sa loob ng function? ans. mag take ng argurment in this case the list of scheds
    * 3. saan gagamitin yung list or argument na ipapass sa lambda? ans. sa viewmodel kung saan gagamitin yung argument,
    * at kung saan i-invoked yung function at i-initialize yung lambda, naka sulat sa loob ng lambda kung ano gagawin sa list*/

    fun getScheduleList(onDataChanged: (List<SchedulingDataClass>) -> Unit) {
        databaseRef.child("Schedule").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var schedID: String
                var days = mutableListOf<Int>()
                var targets = mutableListOf<Int>()
                var amOrPm: String
                var hour: Int
                var minute: Int
                var isActive: Boolean

                var scheduleList = mutableListOf<SchedulingDataClass>()
                if (snapshot.exists()) {
                    for (sched in snapshot.children) {
                        amOrPm = sched.child("amOrPm").value.toString()
                        hour = sched.child("hour").value.toString().toInt()
                        minute = sched.child("minute").value.toString().toInt()
                        isActive = sched.child("isActive").value.toString().toBoolean()
                        schedID = sched.key.toString()

                        Log.i("Hey", "$sched")
                        for (target in sched.child("Targets").children) {
                            Log.i("Hey", "$target")
                            targets.add(target.value.toString().toInt())
                        }
                        for (day in sched.child("days").children) {
                            Log.i("Hey", "$day")
                            days.add(day.value.toString().toInt())
                        }

                        val item = SchedulingDataClass(
                            targets = targets.toList(),
                            days = days.toList(),
                            hour = hour,
                            minute = minute,
                            amOrPm = amOrPm,
                            schedID = schedID,
                            isActive = isActive
                        )
                        scheduleList.add(item)
                        Log.i("Hey", "datachange schedList: $scheduleList")
                        targets.clear()
                        days.clear()
                    }
                    onDataChanged(scheduleList)
                }
            }


            override fun onCancelled(error: DatabaseError) {
                Log.e("MayErrorBro", "$error")
            }
        })
    }

    fun toggleSwitch(status: Boolean, schedID: String) {
        databaseRef.child("Schedule").child(schedID).child("isActive").setValue(status)
            .addOnSuccessListener {
                Toast.makeText(
                    MainScreenContext.getContext(),
                    if (status) "Activated" else "Deactivated",
                    Toast.LENGTH_SHORT
                ).show()
            }.addOnFailureListener {
                Toast.makeText(
                    MainScreenContext.getContext(), "Failed: $it", Toast.LENGTH_SHORT
                ).show()
            }
    }

}