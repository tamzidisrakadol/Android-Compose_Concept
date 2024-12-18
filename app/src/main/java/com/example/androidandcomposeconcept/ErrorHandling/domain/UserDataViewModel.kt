package com.example.androidandcomposeconcept.ErrorHandling.domain

import androidx.lifecycle.ViewModel

class UserDataViewModel(
    private val userDataValidator: UserDataValidator
) : ViewModel() {

    fun onRegisterCallBack(password: String){
        val result = userDataValidator.validatePassword(password)
        when(result){
            is Result.Error -> {
                when(result.error){
                    PasswordError.TOO_SHORT -> {
                       //TODO(): Show error msg
                    }
                    PasswordError.NO_NUMBER -> {
                        //TODO(): Show error msg
                    }
                    PasswordError.NO_UPPERCASE -> {
                        //TODO(): Show error msg
                    }
                }
            }
            is Result.Success -> {
                // show success message //save data to db
            }
        }
    }

}