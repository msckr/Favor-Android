package com.nise.favor_android.Login

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    val email : String,
    val password : String
)