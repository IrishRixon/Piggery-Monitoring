package com.example.dolpiggery.MainScreen.Repository.Pigs

import android.widget.Toast
import com.example.dolpiggery.MainScreen.DataClass.Cubicle.Pig.PigDataClass
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PigsRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun addPigsList(cubicleID: Int, onDataChanged: (List<PigDataClass>) -> Unit) {
        databaseRef.child("Cubicle_$cubicleID").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val pigDataClassList = mutableListOf<PigDataClass>()
                var bpm = 0
                var bodyTemp = 0
                var pigID = 0

                if(snapshot.exists()) {
                    for(child in snapshot.children) {
                        if(child.key?.contains("Pig", true) == true) {
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
                    onDataChanged(pigDataClassList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(MainScreenContext.getContext(), "$error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}