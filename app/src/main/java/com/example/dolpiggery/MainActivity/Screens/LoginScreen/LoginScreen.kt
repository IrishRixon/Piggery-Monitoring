package com.example.dolpiggery.MainActivity.Screens.LoginScreen

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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainActivity.MainActivityContext
import com.example.dolpiggery.MainActivity.Screens.ImageComposables.PigCageImage
import com.example.dolpiggery.MainActivity.UIComponents.EmailOutlineTextField
import com.example.dolpiggery.MainActivity.UIComponents.LoginButton
import com.example.dolpiggery.MainActivity.UIComponents.PasswordOutlineTextField
import com.example.dolpiggery.MainActivity.ViewModel.TextFieldViewModel
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun LoginScreen() {

    /* The TextFieldViewModel class is a subclass of ViewModel,
    so the new instance needs to be initialized with viewModel(). This is done because we need the app
    to remember the state of the mutableStates in TextFieldViewModel across configuration
    such as screen rotations*/
    val viewModel: TextFieldViewModel = viewModel()

    // Below is the UI of Login Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PacificCyan5)
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                PigCageImage(size = 100.dp)

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Log In",
                    color = Snow60,
                    fontSize = 35.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                )

                Spacer(modifier = Modifier.height(20.dp))

                // These are the composables from UIComponents package
                EmailOutlineTextField()
                Spacer(modifier = Modifier.height(5.dp))
                PasswordOutlineTextField()

                Spacer(modifier = Modifier.height(20.dp))
                /* Invoked the LoginButton composable with lambda as an argument.
                That lambda invoke the loginUser function in TextFieldViewModel */
                LoginButton { viewModel.loginUser(MainActivityContext.getContext()) }
            }
        }
    }
}