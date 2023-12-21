package com.nguyenhoangthanhan.featurescompose.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () -> Unit
) {
    val dimSet = remember {
        dimensions
    }
    val mAppOrientation = remember {
        orientation
    }
    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        LocalOrientationMode provides mAppOrientation,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf { smallDimensions }

val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}