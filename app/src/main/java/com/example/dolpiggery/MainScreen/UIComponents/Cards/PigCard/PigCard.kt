package com.example.dolpiggery.MainScreen.UIComponents.Cards.PigCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun PigCard(
    pigID: Int,
    bpm: Int,
    bodyTemp: Int
) {

        Card(
            onClick = { /*TODO*/ },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Snow60),
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(10.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(0.5f)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.pig),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )

                    Text(text = "Pig $pigID", fontSize = 20.sp)
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxSize()
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.heartbeat),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(text = "$bpm", fontSize = 20.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)))
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.temp),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )

                        Text(text = "$bodyTemp°C", fontSize = 20.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)))
                    }
                }
            }
        }
    }
