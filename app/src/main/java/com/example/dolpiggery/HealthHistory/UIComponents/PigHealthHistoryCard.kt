package com.example.dolpiggery.HealthHistory.UIComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Orange
import com.example.dolpiggery.ui.theme.PigmentGreen
import com.example.dolpiggery.ui.theme.Poppy
import com.example.dolpiggery.ui.theme.Snow60
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PigHealthHistoryCard(
    bodyTemp: String,
    counter: Int,
    status: String,
    month: Int,
    day: Int,
    year: Int,
    hour: Int,
    minute: Int,
    amOrPM: String
) {
    val pigBodyTempTooltipState = rememberTooltipState()
    val counterTooltipState = rememberTooltipState()
    val timerTooltipState = rememberTooltipState()

    val bodyTempFloat = bodyTemp.toDoubleOrNull() ?: 0.0
    val formattedBodyTemp = String.format(Locale.getDefault(), "%.1f", bodyTempFloat)


    Card(
        onClick = { },
        enabled = true,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = Snow60,
        ),
    ) {
        Row(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp)
            ) {
                Row(
                    modifier = Modifier.weight(0.6f),
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row {
                            Text(
                                text = "$month-$day-$year  $hour:$minute $amOrPM",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Italic,
                                color = Color.Gray
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.3f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(0.5f)
                            ) {
                                TooltipBox(
                                    positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                                    tooltip = {
                                        PlainTooltip {
                                            Text(text = "Body Temperature of the Pig")
                                        }
                                    },
                                    state = pigBodyTempTooltipState
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.pig_bodytemp),
                                        modifier = Modifier.size(35.dp),
                                        contentDescription = null
                                    )
                                }

                                val txtColor = if (bodyTempFloat >= 40.0) Poppy
                                else if (bodyTempFloat >= 38.0) Orange
                                else Color.Black

                                Text(
                                    text = "$formattedBodyTemp °C",
                                    color = txtColor
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.weight(0.5f)
                            ) {
                                TooltipBox(
                                    positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                                    tooltip = {
                                        PlainTooltip {
                                            Text(
                                                text = "Count how often pig temperature reached 38°C or above today."
                                            )
                                        }
                                    },
                                    state = counterTooltipState
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.counter),
                                        modifier = Modifier.size(27.dp),
                                        contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "$counter")
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.4f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(0.6f)
                            ) {


                                var color = when (status) {
                                    "Normal" -> PigmentGreen
                                    "Hot" -> Orange
                                    else -> Poppy
                                }


                                Text(text = "Status: ", fontSize = 15.sp)
                                Text(text = status, fontSize = 15.sp, color = color)
                            }
                        }
                    }

                }
            }
        }
    }
}