package com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import com.example.dolpiggery.ui.theme.PacificCyan5

@Composable
//@Preview(showBackground = true, backgroundColor = Color.WHITE.toLong())
fun AddSchedOutlinedButton(isUp: Boolean, onClicked: () -> Unit) {
    val icn = if(isUp) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    OutlinedButton(
        onClick = { onClicked() },
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = PacificCyan5)
    ) {
        Icon(imageVector = icn, contentDescription = null)
    }
}