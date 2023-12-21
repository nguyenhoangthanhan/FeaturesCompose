package com.nguyenhoangthanhan.featurescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nguyenhoangthanhan.featurescompose.application.FeaturesComposeAppLandscape
import com.nguyenhoangthanhan.featurescompose.application.FeaturesComposeAppPortrait
import com.nguyenhoangthanhan.featurescompose.ui.theme.AppTheme
import com.nguyenhoangthanhan.featurescompose.ui.theme.FeaturesComposeTheme
import com.nguyenhoangthanhan.featurescompose.util.Orientation
import com.nguyenhoangthanhan.featurescompose.util.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()

            FeaturesComposeTheme(window) {
                if (AppTheme.orientation == Orientation.Portrait){
                    FeaturesComposeAppPortrait()
                }else{
                    FeaturesComposeAppLandscape()
                }
            }
        }
    }
}