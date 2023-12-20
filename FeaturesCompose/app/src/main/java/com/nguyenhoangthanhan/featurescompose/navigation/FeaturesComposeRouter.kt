package com.nguyenhoangthanhan.featurescompose.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    data object SupportALLScreenSizesScreen: Screen()
    data object HomeScreen: Screen()
}

object FeaturesComposeRouter {
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)

    fun navigateTo(screen: Screen){
        currentScreen.value = screen
    }
}