package com.example.dolpiggery.MainActivity.Repository

import android.content.Intent
import android.widget.Toast
import com.example.dolpiggery.MainActivity.MainActivity
import com.example.dolpiggery.MainScreen.MainScreen
import com.google.firebase.auth.FirebaseAuth

class LoginRepository {
    val auth = FirebaseAuth.getInstance()

    val adminUID = "rq0Ss54BuBgCHN6Rj5j80TE3ZYG3"
    val currentUserIUD = auth.currentUser?.uid

    fun loginUserRepo(email: String, password: String, context: MainActivity) {
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(context, "Please enter Inputs", Toast.LENGTH_SHORT).show()
        } else {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                if (currentUserIUD.equals(adminUID)) {
                    Toast.makeText(context, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                }
                Intent(context, MainScreen::class.java).also {
                    context.startActivity(it)
                    context.finish()
                }
            }.addOnFailureListener {
                Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}