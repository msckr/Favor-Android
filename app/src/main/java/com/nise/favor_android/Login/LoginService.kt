package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @POST("/users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<String>

    @FormUrlEncoded
    @PATCH("/users/profile")
    fun changeProfile(
        @Field("userId") userId : String,
        @Field("name") name : String
    ): Call<ChangeProfile>
}