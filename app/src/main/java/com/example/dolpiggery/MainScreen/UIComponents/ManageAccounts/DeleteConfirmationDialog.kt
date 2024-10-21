package com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.MainScreenContext
import com.example.dolpiggery.Navigation.NavRoutes.ManageAccounts
import com.example.dolpiggery.Settings.Screens.ManageAccounts.ViewModel.ManageAccountViewModel
import com.example.dolpiggery.ui.theme.Poppy

@Composable
fun DeleteConfirmationDialog(
    onDismiss: () -> Unit,
    email: String,
    navController: NavHostController,
    uid: String
) {

    val viewModel: ManageAccountViewModel = viewModel()
    AlertDialog(
        shape = RoundedCornerShape(10.dp),
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Poppy,
                    contentColor = Color.White
                ),
                onClick = {
                    viewModel.deleteAccount(uid) {
                        Toast.makeText(
                            MainScreenContext.getContext(),
                            "Account Deleted",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.navigate(ManageAccounts)
                    }
                    onDismiss()
                }
            ) {
                Text(text = "Delete")
            }
        },
        dismissButton = {
            Button(
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                ),
                onClick = { onDismiss() }
            ) {
                Text(text = "Cancel")
            }
        },
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Delete Confirmation")
            }

        },
        text = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Are you sure you want to delete the account '$email'?",
                    textAlign = TextAlign.Center
                )
            }
        },
    )
}