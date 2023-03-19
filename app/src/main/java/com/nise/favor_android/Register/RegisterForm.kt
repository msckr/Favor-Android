package com.nise.favor_android.Register

import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.Repository

class RegisterForm {
    val repo = Repository()

    fun postRegisterForm(email : String, password : String){
        var registerform = LoginRequest(
            email = email,
            password = password
        )
        repo.postRegisterForm(registerform)
    }
}