package com.example.dolpiggery.MainActivity.UIComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.ui.theme.Cerulean5

@Composable
fun LoginButton(
    txt: String = "Log in",
    defaultColor: Color = Cerulean5,
    onClicked: () -> Unit
) {
    // This is the UI of Login Button
    Button(
        onClick = { onClicked() }, // This invoked the lambda that passed as an argument
        colors = ButtonDefaults.buttonColors(containerColor = defaultColor,
            contentColor = Color(0xFFF6F1F1)),
        contentPadding = PaddingValues(15.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = txt,
            fontSize = 18.sp,
            fontWeight = FontWeight(700)
        )
    }
}