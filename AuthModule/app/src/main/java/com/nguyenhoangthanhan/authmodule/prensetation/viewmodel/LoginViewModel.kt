package com.nguyenhoangthanhan.authmodule.prensetation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyenhoangthanhan.authmodule.domain.model.LoginInputValidationType
import com.nguyenhoangthanhan.authmodule.domain.repository.AuthRepository
import com.nguyenhoangthanhan.authmodule.domain.use_case.ValidateLoginInputUseCase
import com.nguyenhoangthanhan.authmodule.prensetation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginInputUseCase: ValidateLoginInputUseCase,
    private val authRepository: AuthRepository
) : ViewModel() {

    var loginState by mutableStateOf(LoginState())
        private set

    fun onEmailInputChange(newValue: String) {
        loginState = loginState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String) {
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformationPassword() {
        loginState = loginState.copy(isPasswordShown = !loginState.isPasswordShown)
        checkInputValidation()
    }

    fun onLoginClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            loginState = try {
                val loginResult = authRepository.login(
                    email = loginState.emailInput,
                    password = loginState.passwordInput
                )
                loginState.copy(isSuccessfullyLoggedIn = loginResult)
            }catch (e: Exception){
                loginState.copy(errorMessageLoginProcess = "Could not login")
            }finally {
                loginState = loginState.copy(isLoading = false)
            }
        }
    }

    private fun checkInputValidation() {
        val validationResult = validateLoginInputUseCase(
            loginState.emailInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(validationResult: LoginInputValidationType) {
        loginState = when (validationResult) {
            LoginInputValidationType.EmptyField -> {
                loginState.copy(errorMessageInput = "Empty fields left", isInputValid = false)
            }

            LoginInputValidationType.NoEmail -> {
                loginState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }

            LoginInputValidationType.Valid -> {
                loginState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }
}