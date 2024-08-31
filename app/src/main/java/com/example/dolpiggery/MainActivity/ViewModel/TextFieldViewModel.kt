package com.example.dolpiggery.MainActivity.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainActivity.MainActivity
import com.example.dolpiggery.MainActivity.Repository.LoginRepository

class TextFieldViewModel: ViewModel() {
    private val loginRepositoy = LoginRepository()
    val emailTxt = mutableStateOf("")
    val passwordTxt = mutableStateOf("")

    fun setEmailTxt(email: String) {
        emailTxt.value = email
    }

    fun setPasswordTxt(password: String) {
        passwordTxt.value = password
    }

    fun loginUser(context: MainActivity) {
        loginRepositoy.loginUserRepo(emailTxt.value, passwordTxt.value, context)
    }
}