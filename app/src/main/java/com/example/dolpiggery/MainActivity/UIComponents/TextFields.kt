package com.example.dolpiggery.MainActivity.UIComponents

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainActivity.ViewModel.TextFieldViewModel
import com.example.dolpiggery.R
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.AddAccountViewModel
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.ManageAccountViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60
import org.w3c.dom.Text
import java.lang.reflect.Modifier

//Custom made reusable composables
@Composable
fun DefaultOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: ImageVector,
    trailingIcon: @Composable (() -> Unit)? = null,
    defaultColor: Color,
    defaultKeyboard: KeyboardOptions = KeyboardOptions.Default,
    defaultSupportingText: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = null) },
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = defaultKeyboard,
        supportingText = defaultSupportingText,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = defaultColor,
            focusedBorderColor = Color(0xFF146C94),
            focusedLabelColor = defaultColor,
            focusedLeadingIconColor = defaultColor,
            unfocusedBorderColor = defaultColor,
            unfocusedLeadingIconColor = defaultColor,
            unfocusedLabelColor = defaultColor,
            unfocusedTextColor = defaultColor,
        )
    )
}

@Composable
fun EmailOutlineTextField(
    defaultColor: Color = Snow60,
    viewModel: TextFieldViewModel
) {

    DefaultOutlineTextField(
        value = viewModel.emailTxt.value,
        onValueChange = { viewModel.setEmailTxt(it) },
        label = "Email",
        leadingIcon = Icons.Default.Email,
        visualTransformation = VisualTransformation.None,
        trailingIcon = null,
        defaultColor = defaultColor
    )
}

@Composable
fun PasswordOutlineTextField(
    defaultColor: Color = Snow60,
    viewModel: TextFieldViewModel
) {
    var showPassword by remember { mutableStateOf(false) }

    DefaultOutlineTextField(
        value = viewModel.passwordTxt.value,
        onValueChange = { viewModel.setPasswordTxt(it) },
        label = "Password",
        leadingIcon = Icons.Default.Lock,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                showPassword = !showPassword
            }) {
                Icon(
                    painter = if (showPassword) painterResource(id = R.drawable.visible) else painterResource(
                        id = R.drawable.non_visible
                    ),
                    contentDescription = null,
                )
            }
        },
        defaultColor = defaultColor
    )
}
