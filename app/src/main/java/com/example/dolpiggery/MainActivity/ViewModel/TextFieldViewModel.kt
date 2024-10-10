package com.example.dolpiggery.MainActivity.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainActivity.MainActivity
import com.example.dolpiggery.MainActivity.Repository.LoginRepository

class TextFieldViewModel: ViewModel() { // Inherits from ViewModel
    private val loginRepositoy = LoginRepository() // Created an instance for the LoginRepository

    // Initialized the mutableStates
    val emailTxt = mutableStateOf("")
    val passwordTxt = mutableStateOf("")

    fun setEmailTxt(email: String) {
        emailTxt.value = email
    }

    fun setPasswordTxt(password: String) {
        passwordTxt.value = password
    }

    /* This function takes the context of the MainActivity as an argument,
    and invoked the loginUserRepo function in LoginRepository and passed the email, password values
    and the context of MainActivity*/
    fun loginUser(context: MainActivity) {
        loginRepositoy.loginUserRepo(emailTxt.value, passwordTxt.value, context)
    }
}