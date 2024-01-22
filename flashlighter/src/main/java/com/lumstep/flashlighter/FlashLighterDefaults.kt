package com.lumstep.flashlighter

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor

/**
 * Default values for FlashLighter composable.
 */
object FlashLighterDefaults {

    /**
     * The default offset used for shifting the flashlight effect (0,0).
     */
    val ShiftOffset = Offset(0f,0f)

    /**
     * The default background brush used for the FlashLighter.
     * It is set to a SolidColor with black color.
     */
    val BackgroundBrush: Brush = SolidColor(Color.Black)

    /**
     * The default brush for the flashlight effect. It creates a radial gradient from white to black.
     *
     * @param center The center of the gradient.
     * @param radius The radius of the gradient.
     * @return The Brush for the flashlight effect.
     */
    val FlashLighterBrush: (center: Offset, radius: Float) -> Brush = { center, radius ->
        Brush.radialGradient(
            0.0f to Color.White.copy(alpha = 0.7f),
            1.0f to Color.Black.copy(alpha = 1f),
            radius = radius,
            center = center,
        )
    }
}
