package com.example.dolpiggery.MainScreen.UIComponents.Measurement.Cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Platinum
import java.util.Locale

@Composable
fun TempCard(
    value: String,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Platinum
        ),
        modifier = Modifier
            .height(100.dp)
            .width(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Image(
                    painter = painterResource(id = if (value > 30.toString()) R.drawable.temp else R.drawable.cold_temp),
                    contentDescription = null
                )

                Text(text = "Temperature")
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Text(
                    text = "$value°C",
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                )
            }
        }
    }
}


@Composable
fun HumidityCard(
    value: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Platinum
        ),
        modifier = Modifier
            .height(100.dp)
            .width(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.humid),
                    contentDescription = null
                )

                Text(text = "Humidity")
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Text(
                    text = "$value%",
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                )
            }
        }
    }
}

@Composable
fun WaterConsumpCard(
    daily: String,
    monthly: String
) {
    val dailyFloat = daily.toDoubleOrNull() ?: 0.0
    val monthlyFloat = monthly.toDoubleOrNull() ?: 0.0
    val formattedDaily = String.format(Locale.getDefault(),"%.2f", dailyFloat)
    val formattedMonthly = String.format(Locale.getDefault(), "%.2f", monthlyFloat)

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Platinum
        ),
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.35f)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.water),
                    contentDescription = null
                )

                Text(text = "Water Consumption")
            }

            HorizontalDivider(thickness = 2.dp)

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.65f)
                    .padding(10.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.5f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.4f)
                    ) {
                        Text(text = "Daily")
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.6f)
                    ) {
                        Text(
                            text = "$formattedDaily L",
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )
                    }
                }

                VerticalDivider(thickness = 2.dp)

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.5f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.4f)
                    ) {
                        Text(text = "Weekly")
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.6f)
                    ) {
                        Text(
                            text = "$formattedMonthly L",
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )
                    }
                }
            }
        }
    }
}


