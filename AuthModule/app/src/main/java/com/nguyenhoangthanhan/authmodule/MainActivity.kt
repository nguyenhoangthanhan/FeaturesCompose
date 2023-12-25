package com.nguyenhoangthanhan.authmodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.nguyenhoangthanhan.authmodule.ui.theme.AuthModuleTheme
import com.nguyenhoangthanhan.authmodule.ui.theme.gray
import com.nguyenhoangthanhan.authmodule.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = gray.toArgb()
        window.navigationBarColor = gray.toArgb()
        setContent {
            AuthModuleTheme {
                Navigation()
            }
        }
    }
}