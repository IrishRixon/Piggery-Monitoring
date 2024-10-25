package com.example.dolpiggery.Settings.Screens.ManageAccounts.ManageAccountsScreen.AddAccountScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainActivity.UIComponents.EmailOutlineTextField
import com.example.dolpiggery.MainActivity.UIComponents.LoginButton
import com.example.dolpiggery.MainActivity.UIComponents.PasswordOutlineTextField
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.MainScreen.UIComponents.TextFields.AddAccountEmailOutlineTextField
import com.example.dolpiggery.MainScreen.UIComponents.TextFields.AddAccountPasswordOutlineTextField
import com.example.dolpiggery.MainScreen.UIComponents.TextFields.AddAccountPhoneNumOutlinedTextField
import com.example.dolpiggery.Navigation.NavRoutes.AddAccount
import com.example.dolpiggery.Navigation.NavRoutes.ManageAccounts
import com.example.dolpiggery.Navigation.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.AddAccountViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.PigmentGreen
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun AddAccountScreen(navController: NavHostController) {
    NavigationCurrentPosition.setCurrentNavDestination("$AddAccount")
    /* The TextFieldViewModel class is a subclass of ViewModel,
    so the new instance needs to be initialized with viewModel(). This is done because we need the app
    to remember the state of the mutableStates in TextFieldViewModel across configuration
    such as screen rotations*/
    val viewModel: AddAccountViewModel = viewModel()

    // Below is the UI of Login Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Snow60)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                PigCageImage(size = 100.dp)

                Spacer(modifier = Modifier.height(25.dp))

                // These are the composables from UIComponents package
                AddAccountEmailOutlineTextField(
                    defaultColor = PacificCyan5,
                    viewModel = viewModel
                ) {
                    Text(text = "Enter a valid email, 'example@gmail.com'")
                }

                AddAccountPasswordOutlineTextField(
                    defaultColor = PacificCyan5,
                    viewModel = viewModel
                ) {
                    Text(text = "Password must be at least 6 characters")
                }

                AddAccountPhoneNumOutlinedTextField(
                    defaultColor = PacificCyan5,
                    viewModel = viewModel
                ) {
                    Text(text = "Enter a valid phone number, '+639xxxxxxxxx'")
                }

                Spacer(modifier = Modifier.height(20.dp))
                /* Invoked the LoginButton composable with lambda as an argument.
                That lambda invoke the loginUser function in TextFieldViewModel */
                LoginButton(txt = "Add account", defaultColor = PigmentGreen) {
                    viewModel.addAccount(
                        MainScreenContext.getContext()
                    ) { code, txt ->
                        Toast.makeText(
                            MainScreenContext.getContext(),
                            txt,
                            Toast.LENGTH_SHORT
                        ).show()
                        
                        if (code == 200) {
                            navController.navigate(ManageAccounts)
                        }
                    }

                }
            }
        }
    }
}