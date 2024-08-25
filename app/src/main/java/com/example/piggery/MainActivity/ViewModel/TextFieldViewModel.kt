package com.example.piggery.MainActivity.ViewModel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.piggery.MainActivity.Repository.LoginRepository

class TextFieldViewModel(private val loginRepository: LoginRepository): ViewModel() {

    val emailTxt = mutableStateOf("")
    val passwordTxt = mutableStateOf("")

    fun setEmailTxt(email: String) {
        emailTxt.value = email
    }

    fun setPasswordTxt(password: String) {
        passwordTxt.value = password
    }

    fun loginUser() {
        loginRepository.logInUser(
            emailTxt.value,
            passwordTxt.value,

        )
    }
}