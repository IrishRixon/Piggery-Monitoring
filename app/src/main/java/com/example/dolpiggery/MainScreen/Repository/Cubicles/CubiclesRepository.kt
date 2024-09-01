package com.example.dolpiggery.MainScreen.Repository.Cubicles

import com.example.dolpiggery.MainScreen.DataClass.Cubicle.CubicleDataClass
import com.example.dolpiggery.MainScreen.DataClass.Pig.PigDataClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CubiclesRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun getCubiclesList(onDataChange: (List<CubicleDataClass>) -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var cubicleID: Int = -1
                var valveSwitch: Boolean = false
                var isNeededClean: Boolean = false

                var pigDataClassList: List<PigDataClass>
                var bpm: Int = -1
                var bodyTemp: Int = -1
                var pigID: Int = -1

                val list = mutableListOf<CubicleDataClass>()
                if (snapshot.exists()) {
                    for (cubicle in snapshot.children) {
                        if(cubicle.key?.contains("Cubicle", true) == true){
                            for (child in cubicle.children) {
                                if (child.key.equals("Cubicle_ID", true)) {
                                    cubicleID = child.value as Int
                                }
                                else if (child.key.equals("valve_switch", true)) {
                                    valveSwitch = child.value as Boolean
                                }
                                else if (child.key.equals("Cubicle_ID", true)) {
                                    isNeededClean = child.value as Boolean
                                }
                                else if(child.key?.contains("Pig", true) == true) {
                                    for(piglet in child.children) {
                                        if(piglet.key.equals("BPM", true)) {
                                            bpm = piglet.value as Int
                                        }
                                        else if(piglet.key.equals("BodyTemp", true)) {
                                            bodyTemp = piglet.value as Int
                                        }
                                        else if(piglet.key?.contains("Pig") == true) {
                                            pigID = piglet.value as Int
                                        }
                                    }
                                    val pigItem = PigDataClass(pigID, bpm, bodyTemp)
                                }
                            }

                            val item = CubicleDataClass(cubicleID, valveSwitch, isNeededClean, pigDataClassList)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}