package com.example.dolpiggery.HealthHistory.Repository

import android.util.Log
import com.example.dolpiggery.HealthHistory.DataClass.pigList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HealthHistoryRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference("Pigs")

    val listOfPigs = mutableListOf<pigList>()

    fun iteratePigs(onDataChanged: (List<pigList>) -> Unit) {
        listOfPigs.clear()
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (pig in snapshot.children) {
                        val pigID = pig.child("Pig_ID").value.toString().toInt()
                        pigList(pigID)
                        listOfPigs.add(pigList(pigID))
                    }
                    onDataChanged(listOfPigs)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}