package com.example.dolpiggery.Settings.Screens.ManageAccounts.ManageAccountsScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.decode.ImageSource
import com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts.AccountCard
import com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts.DeleteConfirmationDialog
import com.example.dolpiggery.Navigation.NavRoutes.ManageAccounts
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.R
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.ManageAccountViewModel
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Snow60
import kotlinx.coroutines.delay

@Composable
fun ManageAccountsScreen(
    navController: NavHostController,
) {

    NavigationCurrentPosition.setCurrentNavDestination("$ManageAccounts")

    val viewModel: ManageAccountViewModel = viewModel()
    val showRefresh = rememberSaveable() {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getUsersAccount()

        delay(10000)
        showRefresh.value = true
    }

    if(showRefresh.value && viewModel.listOfUsersAccount.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pig_crying),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Oops! We’re having trouble connecting. " +
                        "Please check your network connection. " +
                        "If the issue persists, " +
                        "our customer service team is here to help.",
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate(ManageAccounts) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cerulean5,
                    contentColor = Snow60
                )
            ) {
                Text(text = "Refresh")
            }
        }
    }
    else if(viewModel.listOfUsersAccount.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = Cerulean5)
        }
    }
    else {
        if(viewModel.listOfUsersAccount.size == 1) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "No other accounts", fontSize = 20.sp)
            }
        }
        else {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.listOfUsersAccount) {
                    if (it.uid != "dKIMZ74FjtSmvYw4GV5iYW1z0Dg1") {
                        AccountCard(
                            uid = it.uid,
                            email = it.email,
                            phoneNumber = it.phoneNumber,
                            navController = navController
                        )

                        HorizontalDivider(
                            color = Platinum,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                }
            }
        }
    }
}


