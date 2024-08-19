package com.example.piggery.MainActivity.Screens.LoginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piggery.MainActivity.Screens.ImageComposables.PigCageImage
import com.example.piggery.MainActivity.UIComponents.EmailOutlineTextField
import com.example.piggery.MainActivity.UIComponents.LoginButton
import com.example.piggery.MainActivity.UIComponents.PasswordOutlineTextField
import com.example.piggery.R
import com.example.piggery.ui.theme.PacificCyan5
import com.example.piggery.ui.theme.Snow60

@Composable
@Preview
fun LoginScreen() {
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
                PigCageImage(size = 80.dp)

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Log In",
                    color = Snow60,
                    fontSize = 35.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                )

                Spacer(modifier = Modifier.height(20.dp))

                EmailOutlineTextField()
                Spacer(modifier = Modifier.height(5.dp))
                PasswordOutlineTextField()

                Spacer(modifier = Modifier.height(20.dp))
                LoginButton()
            }
        }
    }
}