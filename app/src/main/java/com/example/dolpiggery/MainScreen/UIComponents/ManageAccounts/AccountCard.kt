package com.example.dolpiggery.MainScreen.UIComponents.ManageAccounts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dolpiggery.ui.theme.Poppy
import com.example.dolpiggery.ui.theme.Snow60

@Composable
//@Preview(showBackground = true, backgroundColor = 0xFFF6F1F1)
fun AccountCard(
    uid: String,
    email: String,
    navController: NavHostController
) {

    val showDialog = rememberSaveable {
        mutableStateOf(false)
    }

    TextButton(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth(),
//            .height(120.dp),
//        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(10f),
        colors = ButtonColors(
            containerColor = Snow60,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Black
        )
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ){
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(0.8f)
            ){
                Text(text = uid, color = Color.Gray, fontSize = 10.sp)
                Text(text = email, fontSize = 18.sp)
            }

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(0.2f)
            ){
                Button(
                    onClick = { showDialog.value = true },
                    shape = RoundedCornerShape(10f),
                    colors = ButtonDefaults.buttonColors(Poppy),
                    contentPadding = PaddingValues(5.dp),
                    modifier = Modifier.size(40.dp)

                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        tint = Snow60,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        if(showDialog.value) {
            DeleteConfirmationDialog(
                onDismiss = { showDialog.value = false },
                email = email,
                uid = uid,
                navController = navController
            )
        }
    }
}
