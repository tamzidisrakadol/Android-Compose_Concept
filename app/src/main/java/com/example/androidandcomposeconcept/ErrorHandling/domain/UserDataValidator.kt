package com.example.androidandcomposeconcept.ErrorHandling.domain

class UserDataValidator {
    fun validatePassword(password: String): Result<Unit, PasswordError>{
        if (password.length<6){
            return Result.Error(PasswordError.TOO_SHORT)
        }

        if (!password.any{it.isDigit()}){
            return Result.Error(PasswordError.NO_NUMBER)
        }

        if (!password.any{it.isUpperCase()}){
            return Result.Error(PasswordError.NO_UPPERCASE)
        }

        return Result.Success(Unit)
    }
}



enum class PasswordError: Error{
    TOO_SHORT,
    NO_NUMBER,
    NO_UPPERCASE,
}