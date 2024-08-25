package com.example.piggery.MainActivity.Repository

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.piggery.MainActivity.Context.getContext
import com.example.piggery.MainScreen.MainScreen
import com.google.firebase.auth.FirebaseAuth

class LoginRepository {
    val firebaseAuth = FirebaseAuth.getInstance()
    val uid = "QVY4FoaVWvaBWatTRWi8OOSzELg2"
    val currentUid = firebaseAuth.currentUser?.uid
    fun logInUser(
        email: String,
        password: String,
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                if(currentUid  == uid) {
                    Toast.makeText(getContext(), "Welcome Admin", Toast.LENGTH_SHORT).show()
//                    Intent(getContext(), MainScreen::class.java).also {
//                        getContext().startActivity(it)
//                        getContext().finish()
//                    }
                }
        }
            .addOnFailureListener {
                Toast.makeText(getContext(), "${it.message}", Toast.LENGTH_SHORT).show()
        }
    }
}