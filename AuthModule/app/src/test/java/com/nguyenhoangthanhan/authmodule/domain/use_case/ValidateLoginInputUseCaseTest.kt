package com.nguyenhoangthanhan.authmodule.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.nguyenhoangthanhan.authmodule.domain.model.LoginInputValidationType
import org.junit.Test

class ValidateLoginInputUseCaseTest {

    private val validateLoginInputUseCase = ValidateLoginInputUseCase()

    @Test
    fun `test empty email field returns validation type empty field`(){
        val result = validateLoginInputUseCase(
            email = "",
            password = "password"
        )
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }

    @Test
    fun `test empty password field returns validation type empty field`(){
        val result = validateLoginInputUseCase(
            email = "email",
            password = ""
        )
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }

    @Test
    fun `test no email returns validation type no email`(){
        val result = validateLoginInputUseCase(
            email = "emailgmail.com",
            password = "password"
        )
        assertThat(result).isEqualTo(LoginInputValidationType.NoEmail)
    }

    @Test
    fun `test everything is correct return validation type valid`(){
        val result = validateLoginInputUseCase(
            email = "email@gmail.com",
            password = "password"
        )
        assertThat(result).isEqualTo(LoginInputValidationType.Valid)
    }
}