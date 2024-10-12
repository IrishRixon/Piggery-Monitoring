package com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.InputTime

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.MainScreen.UIComponents.Scheduling.AddSched.AddSchedOutlinedButton
import com.example.dolpiggery.ui.theme.Snow60


@Composable
fun InputTimeTemplate(
    timeTypeValue: String,
    upperLimit: Int,
    lowerLimit: Int,
    viewModelSetTime: (Int) -> Unit,
    zeroPadding: (String) -> String
) {
    var timeState by rememberSaveable { mutableStateOf(timeTypeValue) }

    AddSchedOutlinedButton(isUp = true) {
        val count = if(timeState.toInt() >= upperLimit) lowerLimit else timeState.toInt() + 1
        timeState = count.toString()
        viewModelSetTime(timeState.toInt())
    }

    OutlinedTextField(
        value = zeroPadding(timeState),
        onValueChange =
        {
            val timeValue = if (it.isNotEmpty()) it.toInt() else lowerLimit
            timeState = if(timeValue > upperLimit) (timeValue % 10).toString() else timeValue.toString()
        },
        colors = OutlinedTextFieldDefaults.colors(),
        modifier = Modifier.width(72.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        textStyle = TextStyle(
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    )

    AddSchedOutlinedButton(isUp = false) {
        val count = if(timeState.toInt() <= lowerLimit) upperLimit else timeState.toInt() - 1
        timeState = count.toString()
        viewModelSetTime(timeState.toInt())
    }
}

@Composable
fun AmOrPmUi(isUp: Boolean, valState:String, viewModelSetAmOrPm: (String) -> Unit) {
    var amOrPmState by rememberSaveable {
        mutableStateOf(valState)
    }

    AddSchedOutlinedButton(isUp = isUp) {
        amOrPmState = if(amOrPmState == "AM") "PM" else "AM"
        viewModelSetAmOrPm(amOrPmState)
    }

    OutlinedTextField(
        value = amOrPmState,
        onValueChange = { },
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Snow60),
        modifier = Modifier.width(90.dp),
        singleLine = true,
        readOnly = true,
        textStyle = TextStyle(
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    )

    AddSchedOutlinedButton(isUp = false) {
        amOrPmState = if(amOrPmState == "AM") "PM" else "AM"
        viewModelSetAmOrPm(amOrPmState)
    }
}

fun timeZeroPadding(value: String, timeType: String): String {
    Log.i("Hi", value)
    return if(value.toInt() == 0 && timeType == "Hour") {
        "01"
    }
    else if (value.toInt() < 10) {
        "0$value"
    }
    else {
        value
    }
}