package com.nguyenhoangthanhan.authmodule.domain.use_case

import com.nguyenhoangthanhan.authmodule.domain.model.LoginInputValidationType

class ValidateLoginInputUseCase {

    operator fun invoke(email:String,password:String):LoginInputValidationType{
        if (email.isEmpty() || password.isEmpty()){
            return LoginInputValidationType.EmptyField
        }
        if ("@" !in email){
            return LoginInputValidationType.NoEmail
        }
        return LoginInputValidationType.Valid
    }
}