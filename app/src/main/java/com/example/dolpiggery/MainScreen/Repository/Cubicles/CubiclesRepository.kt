package com.example.dolpiggery.MainScreen.Repository.Cubicles

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CubiclesRepository {

    fun getHeartBeat(keyToCompare: String, onDataChanged: (String) -> Unit) {
        val firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Pig1")

        firebaseDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for(child in snapshot.children) {
                        if(child.key == keyToCompare) {
                            onDataChanged(child.value.toString())
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Hey", "$error")
            }
        })
    }
}