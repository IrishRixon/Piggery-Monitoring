package com.example.dolpiggery.MainScreen.Repository.Cubicles

import android.util.Log
import android.widget.Toast
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.Pig.PigDataClass
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CubiclesRepository {
    //get the reference of the root path of the database
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    /* function to getCubicles list that has the parameter of lambda
     and takes the list of CubiclesDataClass */
    fun getCubiclesList(onDataChanged: (List<CubicleDataClass>) -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            //Invoke everytime the DataChange on database
            override fun onDataChange(snapshot: DataSnapshot) {
                var cubicleID = 0
                var valveSwitch = false
                var isNeededClean = false

                val cubicleList = mutableListOf<CubicleDataClass>()
                if (snapshot.exists()) {
                    // Iterate each children of the
                    for (cubicle in snapshot.children) {
                        if(cubicle.key?.contains("Cubicle", true) == true){
                            for (child in cubicle.children) {
                                if (child.key.equals("Cubicle_ID", true)) {
                                    cubicleID = child.value.toString().toInt()
                                    Log.i("Hey", "$cubicleID")
                                }
                                else if (child.key.equals("valve_switch", true)) {
                                    valveSwitch = child.value.toString().toBoolean()
                                }
                                else if (child.key.equals("isNeededClean", true)) {
                                    isNeededClean = child.value.toString().toBoolean()
                                }
                            }

                            val item = CubicleDataClass(cubicleID, isNeededClean, valveSwitch)
                            cubicleList.add(item)
                        }
                    }
                    onDataChanged(cubicleList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(MainScreenContext.getContext(), "$error", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun toggleSprinklerSwitch(currentStatus: Boolean ,cubicleID: Int) {
        val newStatus = !currentStatus
        databaseRef.child("Cubicle_$cubicleID").child("Valve_switch").setValue(newStatus)
            .addOnFailureListener {
                Toast.makeText(MainScreenContext.getContext(), "$it", Toast.LENGTH_SHORT).show()
            }
    }
}