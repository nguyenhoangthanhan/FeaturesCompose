package com.nguyenhoangthanhan.authmodule.prensetation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.authmodule.prensetation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onLoginSuccessNavigation:()->Unit,
    onNavigateToRegisterScreen:()->Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

}