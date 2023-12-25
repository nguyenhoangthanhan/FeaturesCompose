package com.nguyenhoangthanhan.authmodule.prensetation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyenhoangthanhan.authmodule.domain.model.LoginInputValidationType
import com.nguyenhoangthanhan.authmodule.domain.model.RegisterInputValidationType
import com.nguyenhoangthanhan.authmodule.domain.repository.AuthRepository
import com.nguyenhoangthanhan.authmodule.domain.use_case.ValidateRegisterInputUseCase
import com.nguyenhoangthanhan.authmodule.prensetation.state.LoginState
import com.nguyenhoangthanhan.authmodule.prensetation.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateRegisterInputUseCase: ValidateRegisterInputUseCase,
    private val authRepository: AuthRepository
) : ViewModel() {

    var registerState by mutableStateOf(RegisterState())
        private set

    fun onEmailInputChange(newValue: String) {
        registerState = registerState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String) {
        registerState = registerState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onPasswordRepeatedInputChange(newValue: String) {
        registerState = registerState.copy(passwordRepeatedInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformationPassword() {
        registerState = registerState.copy(isPasswordShown = !registerState.isPasswordShown)
        checkInputValidation()
    }

    fun onToggleVisualTransformationPasswordRepeated() {
        registerState = registerState.copy(isPasswordRepeatedShown = !registerState.isPasswordRepeatedShown)
        checkInputValidation()
    }

    fun onRegisterClick() {
        registerState = registerState.copy(isLoading = true)
        viewModelScope.launch {
            registerState = try {
                val loginResult = authRepository.register(
                    email = registerState.emailInput,
                    password = registerState.passwordInput
                )
                registerState.copy(isSuccessfullyRegistered = loginResult)
            }catch (e: Exception){
                registerState.copy(errorMessageRegisterProcess = "Could not register")
            }finally {
                registerState = registerState.copy(isLoading = false)
            }
        }
    }

    private fun checkInputValidation() {
        val validationResult = validateRegisterInputUseCase(
            registerState.emailInput,
            registerState.passwordInput,
            registerState.passwordRepeatedInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(validationResult: RegisterInputValidationType) {
        registerState = when (validationResult) {
            RegisterInputValidationType.EmptyField -> {
                registerState.copy(errorMessageInput = "Empty fields left", isInputValid = false)
            }

            RegisterInputValidationType.NoEmail -> {
                registerState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }

            RegisterInputValidationType.PasswordTooShort -> {
                registerState.copy(errorMessageInput = "Password too short", isInputValid = false)
            }

            RegisterInputValidationType.PasswordsDoNotMatch -> {
                registerState.copy(
                    errorMessageInput = "Passwords do not match",
                    isInputValid = false
                )
            }

            RegisterInputValidationType.PasswordUpperCaseMissing -> {
                registerState.copy(
                    errorMessageInput = "Password upper case missing",
                    isInputValid = false
                )
            }

            RegisterInputValidationType.PasswordSpecialCharMissing -> {
                registerState.copy(
                    errorMessageInput = "Password special char missing",
                    isInputValid = false
                )
            }

            RegisterInputValidationType.PasswordNumberMissing -> {
                registerState.copy(
                    errorMessageInput = "Password numberMissing",
                    isInputValid = false
                )
            }

            RegisterInputValidationType.Valid -> {
                registerState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }

}