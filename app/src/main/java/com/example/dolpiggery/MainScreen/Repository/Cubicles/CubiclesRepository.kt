package com.example.dolpiggery.MainScreen.Repository.Cubicles

import android.util.Log
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass
import com.example.dolpiggery.MainScreen.DataClass.Pig.PigDataClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CubiclesRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun getCubiclesList(onDataChanged: (List<CubicleDataClass>) -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var cubicleID = 0
                var valveSwitch = false
                var isNeededClean = false

                val pigDataClassList = mutableListOf<PigDataClass>()
                var bpm = 0
                var bodyTemp = 0
                var pigID = 0

                val cubicleList = mutableListOf<CubicleDataClass>()
                if (snapshot.exists()) {
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
                                else if (child.key.equals("Cubicle_ID", true)) {
                                    isNeededClean = child.value.toString().toBoolean()
                                }
                                else if(child.key?.contains("Pig", true) == true) {
                                    for(piglet in child.children) {
                                        if(piglet.key.equals("BPM", true)) {
                                            bpm = piglet.value.toString().toInt()
                                        }
                                        else if(piglet.key.equals("BodyTemp", true)) {
                                            bodyTemp = piglet.value.toString().toInt()
                                        }
                                        else if(piglet.key?.contains("Pig") == true) {
                                            pigID = piglet.value.toString().toInt()
                                        }
                                    }
                                    //continue making lists
                                    val pigItem = PigDataClass(pigID, bpm, bodyTemp)
                                    pigDataClassList.add(pigItem)

                                }
                            }

                            val item = CubicleDataClass(cubicleID, valveSwitch, isNeededClean, pigDataClassList)
                            cubicleList.add(item)
                        }
                    }
                    onDataChanged(cubicleList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}