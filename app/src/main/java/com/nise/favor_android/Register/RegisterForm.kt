package com.nise.favor_android.Register

import Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nise.favor_android.Event
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Login.meuser

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
