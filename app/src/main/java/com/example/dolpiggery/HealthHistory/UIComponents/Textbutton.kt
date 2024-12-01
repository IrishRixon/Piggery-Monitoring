package com.example.dolpiggery.HealthHistory.UIComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainActivity.CurrentUserUID
import com.example.dolpiggery.Navigation.NavRoutes.PigHealthHistory
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun HealthHistoryTextButton(
    navController: NavHostController,
    pigID: Int
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(10f),
        colors = ButtonColors(
            containerColor = Snow60,
            contentColor = Color.Black,
            disabledContainerColor = Snow60,
            disabledContentColor = Color.Gray
        ),
        enabled = true,
        onClick = { navController.navigate(PigHealthHistory(pigID)) }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Pig $pigID",
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )
        }
    }
    HorizontalDivider(color = Color.Gray)
}
