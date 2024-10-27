package com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.MainScreen.MainScreen
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.Settings.Screens.ManageAccounts.Repository.AddAccountRepository

class AddAccountViewModel : ViewModel() {
    val addAccountRepository = AddAccountRepository()

    // Initialized the mutableStates
    val emailTxt = mutableStateOf("")
    val passwordTxt = mutableStateOf("")
    val phoneNumber = mutableStateOf("+639")

    fun setEmailTxt(email: String) {
        emailTxt.value = email
    }

    fun setPasswordTxt(password: String) {
        passwordTxt.value = password
    }

    fun setPhoneNumber(password: String) {
        phoneNumber.value = password
    }

    fun addAccount(context: MainScreen, toast: (code: Int, txt: String) -> Unit) {
        if (emailTxt.value.isEmpty() || passwordTxt.value.isEmpty()) {
            Toast.makeText(
                MainScreenContext.getContext(),
                "Please fill all fields",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            addAccountRepository.addAccount(
                email = emailTxt.value,
                password = passwordTxt.value,
                phoneNumber = phoneNumber.value,
                toast = toast
            )
        }

        Log.i("Yowsi", "addAccount: ${emailTxt.value} ${passwordTxt.value} ${phoneNumber.value}")
    }

    fun patchAccount(uid: String, toast: (code: Int, txt: String) -> Unit) {
        if (emailTxt.value.isEmpty()) {
            Toast.makeText(
                MainScreenContext.getContext(),
                "Please fill all fields",
                Toast.LENGTH_SHORT
            ).show()
        } else {    
            addAccountRepository.patchAccount(
                uid = uid,
                email = emailTxt.value,
                password = passwordTxt.value,
                phoneNumber = phoneNumber.value
            ) { code, txt ->
                toast(code, txt)
            }
        }
    }
}