package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {


    @POST("/users/sign-up")
    fun requestLogin(@Body Login : LoginRequest) : Call<LoginRequest>
}