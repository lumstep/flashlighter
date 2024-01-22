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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lumstep.flashlighter.FlashLighter

@Composable
fun Example5() {
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
            flashLighterBrush = { center: Offset, radius: Float ->
                Brush.radialGradient(
                    0.0f to Color.Black.copy(alpha = 0.7f),
                    1.0f to Color.White.copy(alpha = 1f),
                    radius = radius,
                    center = center,
                )
            },
            backgroundBrush = SolidColor(Color.White),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(30.dp),
                text = "1 1 1 1 2 6",
                fontSize = 46.sp,
                color = Color.Black,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}