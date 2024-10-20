package com.example.dolpiggery.Settings.Screens.ManageAccounts.ManageAccountsScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.ManageAccountViewModel

@Composable
fun ManageAccountsScreen() {
    val viewModel: ManageAccountViewModel = viewModel()

    Log.i("hi", "ManageAccountsScreen: Breakpoint")

    LaunchedEffect(key1 = Unit) {
        Log.i("hi", "ManageAccountsScreen: Breakpoint1")
        viewModel.getUsersAccount()
        Log.i("hi", "ManageAccountsScreen: Breakpoint2")
    }
    if(viewModel.listOfUsersAccount.isEmpty()) {
        Log.i("hi", "ManageAccountsScreen: Breakpoint3")
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        Log.i("hi", "ManageAccountsScreen: Breakpoint4")
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.listOfUsersAccount) {
                Text(text = it.email)
            }
        }
    }
}


