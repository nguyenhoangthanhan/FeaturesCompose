package com.nguyenhoangthanhan.authmodule.prensetation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun NavDestinationHelper(
    shouldNavigate: () -> Boolean,
    destination: () -> Unit
) {
    LaunchedEffect(
        key1 = shouldNavigate(),
        block = {
            if (shouldNavigate()){
                destination()
            }
        }
    )
}