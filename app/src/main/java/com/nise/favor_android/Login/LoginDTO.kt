package com.nise.favor_android.Login


data class LoginRequest (
    val email : String,
    val password : String
)

data class ProfileMake(
    val userId : String,
    val name : String
)

data class userUpdateRequestDto(
    val favorList: List<String>,
    val name: String,
    val userId: String
)