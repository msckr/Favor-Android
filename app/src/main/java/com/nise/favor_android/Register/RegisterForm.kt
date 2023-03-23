package com.nise.favor_android.Register

import Repository
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake

class RegisterForm {
    val repo = Repository()

    fun postRegisterForm(email : String, password : String){
        var registerform = LoginRequest(
            email = email,
            password = password
        )
        repo.postRegisterForm(registerform)
    }

    fun patchMakeProfile(userId:String, name : String){
        var makeProfileForm = ProfileMake(
            userId = userId,
            name = name
        )
        val userNo = 0
        repo.makeProfileForm(makeProfileForm, userNo)
    }
}