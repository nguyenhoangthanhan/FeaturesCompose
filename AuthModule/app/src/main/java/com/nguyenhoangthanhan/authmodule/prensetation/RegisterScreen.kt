package com.nguyenhoangthanhan.authmodule.prensetation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.authmodule.prensetation.components.AuthButton
import com.nguyenhoangthanhan.authmodule.prensetation.components.BubbleAnimation
import com.nguyenhoangthanhan.authmodule.prensetation.components.HeaderBackground
import com.nguyenhoangthanhan.authmodule.prensetation.components.TextEntryModule
import com.nguyenhoangthanhan.authmodule.prensetation.viewmodel.RegisterViewModel
import com.nguyenhoangthanhan.authmodule.ui.theme.gray
import com.nguyenhoangthanhan.authmodule.ui.theme.orange
import com.nguyenhoangthanhan.authmodule.ui.theme.white
import com.nguyenhoangthanhan.authmodule.ui.theme.whiteGray
import com.nguyenhoangthanhan.authmodule.ui.theme.whiteGrayOrange

@Composable
fun RegisterScreen(
    onRegisterSuccessNavigation: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            HeaderBackground(
                leftColor = orange,
                rightColor = whiteGrayOrange,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "Register",
                style = MaterialTheme.typography.headlineMedium,
                color = white,
                fontWeight = FontWeight.SemiBold
            )
        }
        RegisterContainer(
            emailValue = { registerViewModel.registerState.emailInput },
            passwordValue = {
                registerViewModel.registerState.passwordInput
            },
            buttonEnabled = {
                registerViewModel.registerState.isInputValid
            },
            onEmailChanged = registerViewModel::onEmailInputChange,
            onPasswordChanged = registerViewModel::onPasswordInputChange,
            onButtonClick = registerViewModel::onRegisterClick,
            isPasswordShown = {
                registerViewModel.registerState.isPasswordShown
            },
            onTrailingPasswordIconClick = registerViewModel::onToggleVisualTransformationPassword,
            errorHint = {
                registerViewModel.registerState.errorMessageInput
            },
            isLoading = {
                registerViewModel.registerState.isLoading
            },
            modifier = Modifier
                .padding(top = 200.dp)
                .fillMaxWidth(0.9f)
                .shadow(5.dp, RoundedCornerShape(15.dp))
                .background(whiteGray, RoundedCornerShape(15.dp))
                .padding(10.dp, 15.dp, 10.dp, 5.dp)
                .align(Alignment.TopCenter),
            isPasswordRepeatedShown = {
                registerViewModel.registerState.isPasswordRepeatedShown
            },
            onPasswordRepeatedChanged = registerViewModel::onPasswordRepeatedInputChange,
            onTrailingPasswordRepeatedIconClick = registerViewModel::onToggleVisualTransformationPasswordRepeated,
            passwordRepeatedValue = {
                registerViewModel.registerState.passwordRepeatedInput
            }
        )
        BubbleAnimation(
            bubbleColor1 = whiteGrayOrange,
            bubbleColor2 = orange,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .align(Alignment.BottomCenter)
        )
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onNavigateToLoginScreen()
                    },
                text = "Login",
                color = orange,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun RegisterContainer(
    emailValue: () -> String,
    passwordValue: () -> String,
    passwordRepeatedValue: () -> String,
    buttonEnabled: () -> Boolean,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordRepeatedChanged: (String) -> Unit,
    onButtonClick: () -> Unit,
    isPasswordShown: () -> Boolean,
    isPasswordRepeatedShown: () -> Boolean,
    onTrailingPasswordIconClick: () -> Unit,
    onTrailingPasswordRepeatedIconClick: () -> Unit,
    errorHint: () -> String?,
    isLoading: () -> Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        TextEntryModule(
            modifier = Modifier.fillMaxWidth(),
            description = "Email address",
            hint = "ABCDEF@gmail.com",
            textValue = emailValue(),
            textColor = gray,
            cursorColor = orange,
            onValueChanged = onEmailChanged,
            onTrailingIconClick = { },
            leadingIcon = Icons.Default.Email
        )
        TextEntryModule(
            modifier = Modifier.fillMaxWidth(),
            description = "Password",
            hint = "Enter password",
            textValue = passwordValue(),
            textColor = gray,
            cursorColor = orange,
            onValueChanged = onPasswordChanged,
            trailingIcon = Icons.Default.RemoveRedEye,
            onTrailingIconClick = {
                onTrailingPasswordIconClick()
            },
            leadingIcon = Icons.Default.VpnKey,
            visualTransformation = if (isPasswordShown()) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardType = KeyboardType.Password
        )
        TextEntryModule(
            modifier = Modifier.fillMaxWidth(),
            description = "Password repeated",
            hint = "Enter password repeated",
            textValue = passwordRepeatedValue(),
            textColor = gray,
            cursorColor = orange,
            onValueChanged = onPasswordRepeatedChanged,
            trailingIcon = Icons.Default.RemoveRedEye,
            onTrailingIconClick = {
                onTrailingPasswordRepeatedIconClick()
            },
            leadingIcon = Icons.Default.VpnKey,
            visualTransformation = if (isPasswordRepeatedShown()) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardType = KeyboardType.Password
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            AuthButton(
                text = "Register",
                backgroundColor = orange,
                contentColor = white,
                enabled = buttonEnabled(),
                onButtonClick = onButtonClick,
                isLoading = isLoading(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .shadow(5.dp, RoundedCornerShape(25.dp)),
            )
            Text(
                text = errorHint() ?: "",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}