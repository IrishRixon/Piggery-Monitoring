package com.example.piggery.MainActivity.Screens.ImageComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.piggery.R

@Composable
fun PigCageImage(size: Dp) {
    Image(
        painter = painterResource(id = R.drawable.pig_cage),
        contentDescription = null,
        modifier = Modifier
            .size(size),
        contentScale = ContentScale.Crop
    )
}