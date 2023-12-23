package com.nguyenhoangthanhan.authmodule.domain.use_case

import com.nguyenhoangthanhan.authmodule.domain.model.RegisterInputValidationType
import com.nguyenhoangthanhan.authmodule.util.containsNumbers
import com.nguyenhoangthanhan.authmodule.util.containsSpecialChar
import com.nguyenhoangthanhan.authmodule.util.containsUppersCase

class ValidateRegisterInputUseCase {

    operator fun invoke(
        email: String,
        password: String,
        passwordRepeated: String
    ): RegisterInputValidationType {
        if (email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if ("@" !in email) {
            return RegisterInputValidationType.NoEmail
        }
        if (password != passwordRepeated) {
            return RegisterInputValidationType.PasswordsDoNotMatch
        }
        if (password.count() < 8) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!password.containsNumbers()) {
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!password.containsUppersCase()) {
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!password.containsSpecialChar()) {
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid
    }
}