package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @FormUrlEncoded
    @POST("/users/sign-up")
    fun requestLogin(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<LoginRequest>
}