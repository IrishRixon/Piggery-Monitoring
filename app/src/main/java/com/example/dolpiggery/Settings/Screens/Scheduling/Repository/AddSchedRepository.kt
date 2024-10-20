package com.example.dolpiggery.Settings.Screens.Scheduling.Repository

import com.example.dolpiggery.Settings.Screens.Scheduling.DataClass.AddAndEditScheduleDataClass
import com.google.firebase.database.FirebaseDatabase

class AddSchedRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun addSchedule(
        schedulingDataClass: AddAndEditScheduleDataClass,
        callBack: (Any, String) -> Unit,
        loadDeactivate: () -> Unit
    ) {

        databaseRef.child("Schedule").push().setValue(schedulingDataClass).addOnSuccessListener {
            loadDeactivate()
            callBack(true, "add")
        }.addOnFailureListener {
            callBack(it.message.toString(), "add")
            loadDeactivate()
        }
    }

    fun updateSchedule(
        addAndEditScheduleDataClass: AddAndEditScheduleDataClass,
        schedID: String,
        callBack: (Any, String) -> Unit,
        loadDeactivate: () -> Unit
    ) {
        databaseRef.child("Schedule").child(schedID).setValue(addAndEditScheduleDataClass).addOnSuccessListener {
            loadDeactivate()
            callBack(true, "update")
        }.addOnFailureListener {
            callBack(it.message.toString(), "update")
            loadDeactivate()
        }
    }
}