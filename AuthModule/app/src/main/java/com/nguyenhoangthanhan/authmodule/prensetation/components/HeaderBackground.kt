package com.nguyenhoangthanhan.authmodule.prensetation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nguyenhoangthanhan.authmodule.ui.theme.orange
import com.nguyenhoangthanhan.authmodule.ui.theme.whiteGrayOrange

@Composable
fun HeaderBackground(
    topColor: Color,
    bottomColor: Color,
    modifier: Modifier = Modifier
) {
    val colorList = remember {
        listOf(topColor, bottomColor)
    }

    Canvas(
        modifier = modifier,
        onDraw = {
            drawCircle(
                radius = size.width,
                center = Offset(center.x, -size.width / 1.5f),
                brush = Brush.linearGradient(
                    colorList,
                    end = Offset(center.x + 500f, 0f)
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderBackground() {
    HeaderBackground(
        topColor = orange,
        bottomColor = whiteGrayOrange,
        modifier = Modifier.fillMaxSize()
    )
}