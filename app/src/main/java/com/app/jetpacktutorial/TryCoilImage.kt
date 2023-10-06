package com.app.jetpacktutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@Composable
fun CoilImage(){
    Box (modifier = Modifier
        .width(150.dp)
        .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/14994036?v=4",
            builder = {
                placeholder(R.drawable.imageplaceholder)
            }
        )
        Image(painter = painter, contentDescription = "Android Logo")
        val painterState = painter.state
        if (painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}