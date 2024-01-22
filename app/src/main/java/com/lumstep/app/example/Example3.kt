package com.lumstep.app.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lumstep.flashlighter.FlashLighter

@Composable
fun Example3() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Your verification code", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(50.dp))
        FlashLighter(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp)),
            radius = 150f,
            shiftOffset = Offset(-120f, -120f),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "1 1 1 1 2 6",
                fontSize = 46.sp,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}