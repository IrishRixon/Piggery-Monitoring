package com.example.dolpiggery.Settings.Screens.ManageAccounts.ManageAccountsScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts.AccountCard
import com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts.DeleteConfirmationDialog
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.ManageAccountViewModel
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.Platinum

@Composable
fun ManageAccountsScreen(navController: NavHostController) {
    val viewModel: ManageAccountViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.getUsersAccount()
    }

    if(viewModel.listOfUsersAccount.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = Cerulean5)
        }
    }
    else {

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.listOfUsersAccount) {
                if(it.uid != "rP1Xjk74I9hARbytAqo6IQXjt9q2") {
                    AccountCard(it.uid, it.email, navController = navController)

                    HorizontalDivider(
                        color = Platinum,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}


