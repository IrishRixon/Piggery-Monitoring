package com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.LimeGreen
import com.example.dolpiggery.ui.theme.Snow60

@Composable
@Preview
fun CubicleCard() {

    var sprinklerSwitch by rememberSaveable {
        mutableStateOf(false)
    }

    var broomTint by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Snow60)
            .padding(16.dp)
    )
    {
        Card(
            onClick = { /*TODO*/ },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Snow60),
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pig_cage),
                        contentDescription = null
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .width(120.dp)
                        .fillMaxHeight()
                ) {
                    Box{
                        Icon(
                            painter = painterResource(id = R.drawable.broom1),
                            tint = if(!broomTint) Color.Black else Color.Red,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(text = "10:00", fontSize = 20.sp, color = if(sprinklerSwitch) Color.Black else Snow60 )

                        Switch(
                            checked = sprinklerSwitch,
                            onCheckedChange = { sprinklerSwitch = it },
                            thumbContent = { Icon(
                                painter = painterResource(id = if(!sprinklerSwitch) R.drawable.shower_off else R.drawable.shower_on ),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )},
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
