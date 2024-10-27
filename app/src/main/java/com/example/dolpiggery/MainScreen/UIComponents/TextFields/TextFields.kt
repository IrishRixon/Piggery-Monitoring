package com.example.dolpiggery.MainScreen.UIComponents.TextFields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainActivity.UIComponents.DefaultOutlineTextField
import com.example.dolpiggery.R
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.AddAccountViewModel
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun AddAccountEmailOutlineTextField(
    defaultColor: Color = Snow60,
    viewModel: AddAccountViewModel,
    defaultSupportingText: @Composable (() -> Unit)? = null
) {

    DefaultOutlineTextField(
        value = viewModel.emailTxt.value,
        onValueChange = { viewModel.setEmailTxt(it) },
        label = "Email",
        leadingIcon = Icons.Default.Email,
        visualTransformation = VisualTransformation.None,
        trailingIcon = null,
        defaultColor = defaultColor,
        defaultSupportingText = defaultSupportingText
    )
}

@Composable
fun AddAccountPasswordOutlineTextField(
    defaultColor: Color = Snow60,
    viewModel: AddAccountViewModel,
    label: String,
    defaultSupportingText: @Composable (() -> Unit)? = null
) {
    var showPassword by remember { mutableStateOf(false) }

    DefaultOutlineTextField(
        value = viewModel.passwordTxt.value,
        onValueChange = { viewModel.setPasswordTxt(it) },
        label = label,
        leadingIcon = Icons.Default.Lock,
        visualTransformation =  if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                showPassword = !showPassword
            }) {
                Icon(
                    painter = if(showPassword) painterResource(id = R.drawable.visible) else painterResource(id = R.drawable.non_visible),
                    contentDescription = null,
                )
            }
        },
        defaultColor = defaultColor,
        defaultSupportingText = defaultSupportingText
    )
}

@Composable
fun AddAccountPhoneNumOutlinedTextField(
    defaultColor: Color = Snow60,
    viewModel: AddAccountViewModel,
    defaultSupportingText: @Composable (() -> Unit)? = null,
) {

    DefaultOutlineTextField(
        value = viewModel.phoneNumber.value,
        onValueChange = {
            if(it.length in 4..13) viewModel.setPhoneNumber(it)
        },
        label = "Phone Number",
        leadingIcon = Icons.Default.Phone,
        visualTransformation = VisualTransformation.None,
        trailingIcon = null,
        defaultColor = defaultColor,
        defaultKeyboard = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        defaultSupportingText = defaultSupportingText
    )
}