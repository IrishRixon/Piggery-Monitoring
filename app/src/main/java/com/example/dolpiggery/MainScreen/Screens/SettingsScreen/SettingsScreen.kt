package com.example.dolpiggery.MainScreen.Screens.SettingsScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun SettingsScreen() {
//    Text(
//        text = "Settings",
//        fontSize = 50.sp
//    )

    val optList = listOf("Scheduling", "Manage Accounts")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(optList) {
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                shape = RoundedCornerShape(10f),
                colors = ButtonColors(
                    containerColor = Snow60,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.Black
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = it,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
            }
            HorizontalDivider(color = Color.Gray)
        }
    }
}