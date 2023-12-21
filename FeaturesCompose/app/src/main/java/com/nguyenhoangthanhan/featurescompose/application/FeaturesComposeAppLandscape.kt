package com.nguyenhoangthanhan.featurescompose.application

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nguyenhoangthanhan.featurescompose.navigation.FeaturesComposeRouter
import com.nguyenhoangthanhan.featurescompose.navigation.Screen
import com.nguyenhoangthanhan.featurescompose.ui.screens.landscape.HomeScreenLandscape
import com.nguyenhoangthanhan.featurescompose.ui.screens.landscape.SupportALLScreenSizesScreenLandscape

@Composable
fun FeaturesComposeAppLandscape() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Crossfade(targetState = FeaturesComposeRouter.currentScreen, label = "") { router ->
            when (router.value) {
                is Screen.HomeScreen -> {
                    HomeScreenLandscape()
                }

                is Screen.SupportALLScreenSizesScreen -> {
                    SupportALLScreenSizesScreenLandscape()
                }
            }
        }
    }
}