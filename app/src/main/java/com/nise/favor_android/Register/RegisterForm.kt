package com.nise.favor_android.Register

import Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nise.favor_android.Event
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake

class RegisterForm {
    val repo = Repository()
    private var _submit = MutableLiveData<Event<Boolean>>()
    val submit : LiveData<Event<Boolean>> = _submit
    fun postRegisterForm(email : String, password : String){
        var registerform = LoginRequest(
            email = email,
            password = password
        )
        repo.postRegisterForm(registerform)
        _submit.postValue(Event(true))
    }
}