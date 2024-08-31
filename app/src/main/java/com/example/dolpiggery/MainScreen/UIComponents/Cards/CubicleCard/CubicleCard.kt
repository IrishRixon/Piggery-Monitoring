package com.example.dolpiggery.MainScreen.UIComponents.Cards.CubicleCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
@Preview
fun CubicleCard() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Snow60)
        .padding(16.dp)) {
        Surface(
            onClick = { /*TODO*/ },
            color = Snow60,
            contentColor = PacificCyan5,
            shadowElevation = 10.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
            ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Box (modifier = Modifier.width(100.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.pig_cage),
                        contentDescription = null,
                        modifier = Modifier.size(130.dp)
                    )
                }
            }
        }
    }
}