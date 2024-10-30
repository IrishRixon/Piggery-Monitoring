package com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolpiggery.MainActivity.CurrentUserUID
import com.example.dolpiggery.Pigs.ViewModel.Cubicles.CubiclesViewModel
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.LimeGreen
import com.example.dolpiggery.ui.theme.Orange
import com.example.dolpiggery.ui.theme.Poppy
import com.example.dolpiggery.ui.theme.Snow60
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PigCard(
    pigID: Int,
    pigBodyTemp: String,
    sprinklerSwitch: Boolean,
    counter: Int,
    timer: Int
) {

    val viewModel: CubiclesViewModel = viewModel()
    val pigBodyTempTooltipState = rememberTooltipState()
    val counterTooltipState = rememberTooltipState()
    val timerTooltipState = rememberTooltipState()

    val bodyTempFloat = pigBodyTemp.toDoubleOrNull() ?: 0.0
    val formattedBodyTemp = String.format(Locale.getDefault(), "%.1f", bodyTempFloat)

    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(6.dp)
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
                    modifier = Modifier
                        .width(50.dp)
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pig),
                        modifier = Modifier.size(40.dp),
                        contentDescription = null
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row {
                        Text(text = "Pig $pigID", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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

                            Text(text = "$formattedBodyTemp °C", color = txtColor)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(0.5f)
                        ) {
                            TooltipBox(
                                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                                tooltip = {
                                    PlainTooltip {
                                        Text(text = "Timer of the sprinkler")
                                    }
                                },
                                state = timerTooltipState
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.timer),
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = null
                                )
                            }

                            viewModel.zeroPaddingTimer(timer = timer)
                            Text(text = if (timer == 0) "--:--" else "${viewModel.minutesString} : ${viewModel.secondsString}")
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.4f)
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

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.1f)
            ) {
//                Box {
//                    Icon(
//                        painter = painterResource(id = R.drawable.broom1),
//                        tint = if (!broomTint) Color.Black else Color.Red,
//                        contentDescription = null,
//                        modifier = Modifier.size(35.dp)
//                    )
//                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if(CurrentUserUID.getUID() == "8F8R3yapjONx6wshGhB84f9HOnS2") {
                        Switch(
                            checked = sprinklerSwitch,
                            onCheckedChange = {
                                viewModel.toggleSprinklerSwitch(
                                    sprinklerSwitch,
                                    pigID
                                )
                            },
                            thumbContent = {
                                Icon(
                                    painter = painterResource(id = if (!sprinklerSwitch) R.drawable.shower_off else R.drawable.shower_on),
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            colors = SwitchDefaults.colors(
                                uncheckedTrackColor = Color.Gray,
                                uncheckedThumbColor = Snow60,
                                checkedTrackColor = LimeGreen,
                                checkedThumbColor = Snow60,
                                checkedIconColor = Color.Black,
                                uncheckedIconColor = Color.Gray
                            )
                        )
                    }
                }
            }
        }
    }
}

