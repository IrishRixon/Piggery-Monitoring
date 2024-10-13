package com.example.dolpiggery.Pigs.Repository

import android.widget.Toast
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.Pigs.DataClass.Pigs.PigsDataClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PigsRepository {
    //get the reference of the root path of the database
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    /* function to getCubicles list that has the parameter of lambda
     and takes the list of CubiclesDataClass */

    fun getPigsList(onDataChanged: (List<PigsDataClass>) -> Unit) {
        databaseRef.child("Pigs").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var pigID: Int
                var bodyTemp: String
                var valveSwitch: Boolean

                val pigsList = mutableListOf<PigsDataClass>()

                if(snapshot.exists()) {
                    for(pig in snapshot.children) {
                        pigID = pig.child("Pig_ID").value.toString().toInt()
                        bodyTemp = pig.child("Body_Temp").value.toString()
                        valveSwitch = pig.child("Valve_Switch").value.toString().toBoolean()

                        val item = PigsDataClass(pigID, bodyTemp, valveSwitch)
                        pigsList.add(item)
                        onDataChanged(pigsList)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    fun toggleSprinklerSwitch(currentStatus: Boolean, pigID: Int) {
        val newStatus = !currentStatus
        databaseRef.child("Pigs").child("Pig_$pigID").child("Valve_Switch").setValue(newStatus)
            .addOnFailureListener {
                Toast.makeText(MainScreenContext.getContext(), "$it", Toast.LENGTH_SHORT).show()
            }
    }
}