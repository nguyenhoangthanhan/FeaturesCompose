package com.nguyenhoangthanhan.featurescompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.featurescompose.navigation.FeaturesComposeRouter
import com.nguyenhoangthanhan.featurescompose.navigation.Screen
import com.nguyenhoangthanhan.featurescompose.navigation.SystemBackButtonHandler

@Composable
fun SupportALLScreenSizesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                FeaturesComposeRouter.navigateTo(Screen.SupportALLScreenSizesScreen)
            }
        ) {
            Text(text = "SupportALLScreenSizesScreen")
        }
    }

    SystemBackButtonHandler {
        FeaturesComposeRouter.navigateTo(Screen.HomeScreen)
    }
}