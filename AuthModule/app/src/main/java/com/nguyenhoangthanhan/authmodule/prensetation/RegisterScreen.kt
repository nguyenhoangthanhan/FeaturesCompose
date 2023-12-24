package com.nguyenhoangthanhan.authmodule.prensetation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.authmodule.prensetation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    onRegisterSuccessNavigation: () -> Unit,
    onNavigateToRegisterScreen: () -> Unit,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {

}