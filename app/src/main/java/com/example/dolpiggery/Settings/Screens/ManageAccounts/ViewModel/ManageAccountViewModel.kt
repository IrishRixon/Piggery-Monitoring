package com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.UserAccount
import com.example.dolpiggery.Settings.Screens.ManageAccounts.Repository.ManageAccountsRepository


class ManageAccountViewModel: ViewModel() {
    val manageAccountsRepository = ManageAccountsRepository()
    var listOfUsersAccount = mutableStateListOf<UserAccount>()

    fun getUsersAccount() {
        Log.i("hi", "viewModel: Breakpoint")
        manageAccountsRepository.getUsersAccount {
            listOfUsersAccount.clear()
            listOfUsersAccount.addAll(it)

            Log.i("Yowsi", "getUsersAccount: ${listOfUsersAccount}")
        }
    }
}