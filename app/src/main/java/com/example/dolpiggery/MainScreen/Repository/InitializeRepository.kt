package com.example.dolpiggery.MainScreen.Repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class InitializeRepository {
    val databaseRef = FirebaseDatabase.getInstance().getReference()

    fun initialize() {
        databaseRef.child("Pigs").addListenerForSingleValueEvent( object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for(child in snapshot.children) {
                        val key = child.key!!
                        databaseRef.child("Pigs").child(key).child("isActive").setValue(false)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}