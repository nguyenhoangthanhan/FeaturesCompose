package com.nguyenhoangthanhan.featurescompose.ui.screens.portrait

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun SupportALLScreenSizesScreenPortrait() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "Image 1",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = AppTheme.dimens.medium,
                            bottomStart = AppTheme.dimens.medium
                        )
                    )
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.large)
        ) {
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
        }
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

    SystemBackButtonHandler {
        FeaturesComposeRouter.navigateTo(Screen.HomeScreen)
    }
}