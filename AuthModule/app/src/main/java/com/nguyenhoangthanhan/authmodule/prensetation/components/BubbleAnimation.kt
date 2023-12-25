package com.nguyenhoangthanhan.authmodule.prensetation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.authmodule.ui.theme.gray
import com.nguyenhoangthanhan.authmodule.ui.theme.orange
import com.nguyenhoangthanhan.authmodule.ui.theme.white

@Composable
fun BubbleAnimation(
    bubbleColor1: Color,
    bubbleColor2: Color,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    Box(
        modifier = modifier
    ) {
        val xValue by infiniteTransition.animateFloat(
            initialValue = 50f,
            targetValue = 670f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        val yValue by infiniteTransition.animateFloat(
            initialValue = 50f,
            targetValue = 350f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        val xValue2 by infiniteTransition.animateFloat(
            initialValue = 670f,
            targetValue = 50f,
            animationSpec = infiniteRepeatable(
                animation = tween(8000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        val yValue2 by infiniteTransition.animateFloat(
            initialValue = 200f,
            targetValue = 100f,
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        val xValue3 by infiniteTransition.animateFloat(
            initialValue = 250f,
            targetValue = 100f,
            animationSpec = infiniteRepeatable(
                animation = tween(7500, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        val yValue3 by infiniteTransition.animateFloat(
            initialValue = 375f,
            targetValue = 150f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawCircle(
                    brush = Brush.linearGradient(
                        listOf(bubbleColor1, bubbleColor2),
                        start = Offset(xValue - 45, yValue),
                        end = Offset(xValue + 45, yValue)
                    ),
                    radius = 50f,
                    center = Offset(xValue, yValue)
                )
                drawCircle(
                    brush = Brush.linearGradient(
                        listOf(bubbleColor1, bubbleColor2),
                        start = Offset(xValue2 - 45, yValue),
                        end = Offset(xValue2 + 45, yValue)
                    ),
                    radius = 50f,
                    center = Offset(xValue2, yValue2)
                )
                drawCircle(
                    brush = Brush.linearGradient(
                        listOf(bubbleColor1, bubbleColor2),
                        start = Offset(xValue3 - 45, yValue),
                        end = Offset(xValue3 + 45, yValue)
                    ),
                    radius = 35f,
                    center = Offset(xValue3, yValue3)
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BubbleAnimationPreview() {
    BubbleAnimation(
        bubbleColor1 = orange,
        bubbleColor2 = gray,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}