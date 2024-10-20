package com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.Targets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.Settings.Screens.Scheduling.ViewModel.AddSchedViewModel.AddSchedViewModel
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Platinum
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun TargetButton(viewModel: AddSchedViewModel, target: Int) {
    val isSelected = viewModel.targetsList.contains(target)

    OutlinedButton(
        onClick = { if(!isSelected) viewModel.addTarget(target) else viewModel.removeTarget(target) },
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
        Text(text = "$target", fontSize = 12.sp)
    }
}