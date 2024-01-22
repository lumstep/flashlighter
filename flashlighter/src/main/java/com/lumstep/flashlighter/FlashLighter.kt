package com.lumstep.flashlighter

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize

/**
 * Composable that simulates a flashlight effect to highlight content.
 *
 * @param modifier The modifier to be applied to the FlashLighter.
 * @param radius The radius of the flashlight effect.
 * @param shiftOffset The offset for shifting the flashlight effect.
 * @param backgroundBrush The brush for the background.
 * @param flashLighterBrush The brush for the flashlight effect.
 * @param content The content to be displayed inside the FlashLighter.
 */
@Composable
fun FlashLighter(
    modifier: Modifier = Modifier,
    radius: Float,
    shiftOffset: Offset = FlashLighterDefaults.ShiftOffset,
    backgroundBrush: Brush = FlashLighterDefaults.BackgroundBrush,
    flashLighterBrush: (center: Offset, radius: Float) -> Brush = FlashLighterDefaults.FlashLighterBrush,
    content: @Composable BoxScope.() -> Unit,
) {
    val density = LocalDensity.current

    var maxSize by remember {
        mutableStateOf(DpSize.Zero)
    }

    Box(
        modifier =
            Modifier
                .onSizeChanged {
                    with(density) {
                        maxSize =
                            DpSize(
                                width = it.width.toDp(),
                                height = it.height.toDp(),
                            )
                    }
                },
    ) {
        var tapPoint: Offset? by remember { mutableStateOf(null) }

        content()

        Canvas(
            modifier =
                modifier
                    .size(maxSize)
                    .clipToBounds()
                    .clickable(
                        enabled = false,
                        onClick = {},
                    )
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { startOffset ->
                                tapPoint = startOffset + shiftOffset
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                tapPoint =
                                    tapPoint?.let { coordinates ->
                                        Offset(
                                            x = coordinates.x + dragAmount.x,
                                            y = coordinates.y + dragAmount.y,
                                        )
                                    }
                            },
                            onDragCancel = {
                                tapPoint = null
                            },
                            onDragEnd = {
                                tapPoint = null
                            },
                        )
                    },
        ) {
            val path =
                Path().apply {
                    moveTo(0f, 0f)
                    lineTo(size.width, 0f)
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    lineTo(0f, 0f)

                    tapPoint?.let {
                        moveTo(it.x - radius, it.y - radius)
                        addOval(
                            Rect(
                                Offset(it.x - radius, it.y - radius),
                                Offset(it.x + radius, it.y + radius),
                            ),
                        )
                    }
                    close()
                }

            drawPath(path, backgroundBrush)

            tapPoint?.let {
                val center = Offset(it.x, it.y)

                drawCircle(
                    brush = flashLighterBrush(center, radius),
                    center = center,
                    radius = radius + 1,
                )
            }
        }
    }
}
