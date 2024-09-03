package com.example.dolpiggery.MainScreen.Screens.CubiclesScreen.DetailsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolpiggery.MainScreen.DataClass.Pig.PigDataClass
import com.example.dolpiggery.MainScreen.UIComponents.Cards.PigCard.PigCard
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun DetailScreen(
    cubicleID: Int,
    pigList: List<PigDataClass>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Snow60)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.weight(0.3f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .border(border = BorderStroke(1.dp, Color.Black), RectangleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pig_cage),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Cubicle $cubicleID",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .weight(0.69f)
                    .height(50.dp)
            ) {
                LazyColumn (
                    modifier = Modifier.fillMaxSize()
                ){
                    items(pigList) {
                        PigCard(
                            it.pigID,
                            it.bpm,
                            it.bodyTemp
                        )
                    }
                }
            }
        }
    }
}