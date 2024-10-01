package com.example.dolpiggery.MainScreen.UIComponents.Scheduling

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun SchedDefaultOutLinedTextField(
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    state: MutableState<Any>? = null,
    onValueChanged: (String) -> Unit
) {

        OutlinedTextField(
            value = if(readOnly) "Cubicle" else state!!.value.toString(),
            onValueChange = onValueChanged,
            singleLine = true,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF000000),
                focusedBorderColor = Color(0xFF146C94),
                focusedLabelColor = Color(0xFFF6F1F1),
                focusedLeadingIconColor = Color(0xFFF6F1F1),
                unfocusedBorderColor = PacificCyan5,
                unfocusedLeadingIconColor = Color(0xFFF6F1F1),
                unfocusedLabelColor = Color(0xFFF6F1F1),
                unfocusedTextColor = Color(0xFF000000),
            )
        )

}