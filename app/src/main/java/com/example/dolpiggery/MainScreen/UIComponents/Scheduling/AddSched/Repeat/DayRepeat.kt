package com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.Repeat

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.MainScreen.ViewModel.Scheduling.AddSchedViewModel.AddSchedViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Snow60

@Composable
//@Preview(showBackground = true, backgroundColor = Color.WHITE.toLong())
fun DayRepeatButton(viewModel: AddSchedViewModel, day: Int) {

    val isSelected = viewModel.daysRepeatList.contains(day)
    val dayString = dayIntToDayString(day)
    OutlinedButton(
        onClick = { if(!isSelected) viewModel.addDayRepeat(day) else viewModel.removeDayRepeat(day) },
        shape = CircleShape,
        modifier = Modifier
            .clip(CircleShape)
            .size(40.dp), // Clip to a circle
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = if (isSelected) Snow60 else PacificCyan5,
            containerColor = if (isSelected) PacificCyan5 else Snow60
        ),
        border = BorderStroke(1.dp, Platinum),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text = dayString, fontSize = 12.sp)
    }

    Log.i("Hi", "${viewModel.daysRepeatList}")
}

fun dayIntToDayString(dayInt: Int): String {
    return when(dayInt) {
        0 -> "Sun"
        1 -> "Mon"
        2 -> "Tue"
        3 -> "Wed"
        4 -> "Thu"
        5 -> "Fri"
        6 -> "Sat"
        else -> "Error"
    }
}