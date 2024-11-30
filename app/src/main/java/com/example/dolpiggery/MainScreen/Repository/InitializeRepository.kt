package com.example.dolpiggery.MainScreen.Repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class InitializeRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun initialize() {
        databaseRef.child("Pigs").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (child in snapshot.children) {
                        val key = child.key!!
                        databaseRef.child("Pigs").child(key).child("isActive").setValue(false)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Yowsi", "onCancelled: Pigs' isActive initialization cancelled")
            }
        })

        databaseRef.child("Environment")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        databaseRef.child("Environment").child("isActive").setValue(false)
                        databaseRef.child("Environment").child("Water_consump").child("isActive").setValue(false)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.i("Yowsi", "onCancelled: Environment' isActive initialization cancelled")
                }
            })
    }
}