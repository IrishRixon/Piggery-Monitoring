package com.example.piggery.MainActivity.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TextFieldViewModel: ViewModel() {
    val emailTxt = mutableStateOf("")
    val passwordTxt = mutableStateOf("")

    fun setEmailTxt(email: String) {
        emailTxt.value = email
    }

    fun setPasswordTxt(password: String) {
        passwordTxt.value = password
    }
}