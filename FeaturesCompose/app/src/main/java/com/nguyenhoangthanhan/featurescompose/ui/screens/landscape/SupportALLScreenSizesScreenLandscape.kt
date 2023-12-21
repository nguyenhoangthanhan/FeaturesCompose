package com.nguyenhoangthanhan.featurescompose.ui.screens.landscape

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.nguyenhoangthanhan.featurescompose.R
import com.nguyenhoangthanhan.featurescompose.navigation.FeaturesComposeRouter
import com.nguyenhoangthanhan.featurescompose.navigation.Screen
import com.nguyenhoangthanhan.featurescompose.navigation.SystemBackButtonHandler
import com.nguyenhoangthanhan.featurescompose.ui.theme.AppTheme

@Composable
fun SupportALLScreenSizesScreenLandscape() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img2),
                contentDescription = "Image 2",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topEnd = AppTheme.dimens.medium,
                            bottomEnd = AppTheme.dimens.medium
                        )
                    )
                    .fillMaxHeight()
            )
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                .padding(AppTheme.dimens.mediumLarge),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "This Application support all screen sizes and landscape mode",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Text(
                text = "You can have the maximum flexibility regarding your UI using this approach",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.mediumLarge),
                shape = CircleShape
            ) {
                Text(
                    text = "Let's go",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(AppTheme.dimens.medium )
                )
            }
        }

    }

    SystemBackButtonHandler {
        FeaturesComposeRouter.navigateTo(Screen.HomeScreen)
    }
}