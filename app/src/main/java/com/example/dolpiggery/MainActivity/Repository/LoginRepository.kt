package com.example.dolpiggery.MainActivity.Repository

import android.content.Intent
import android.widget.Toast
import com.example.dolpiggery.MainActivity.MainActivity
import com.example.dolpiggery.MainScreen.MainScreen
import com.google.firebase.auth.FirebaseAuth

class LoginRepository {
    val auth = FirebaseAuth.getInstance() // Created Instance of the FirebaseAuth

//    val adminUID = "rP1Xjk74I9hARbytAqo6IQXjt9q2"
//    val currentUserIUD = auth.currentUser?.uid

    fun loginUserRepo(email: String, password: String, context: MainActivity) {
        // Checks if the credentials are filled or not
        if (email.isEmpty() && password.isEmpty()) {
            //If the credentials are empty this block will execute
            Toast.makeText(context, "Please enter Inputs", Toast.LENGTH_SHORT).show()
        } else {
            // else invoked the signInWithEmailAndPassword function
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                /* If the result is successful this block will execute */
                Intent(context, MainScreen::class.java).also {
                    context.startActivity(it)
                    context.finish()
                }
            }.addOnFailureListener {
                // If the result is failed are incorrect this block will execute
                Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}