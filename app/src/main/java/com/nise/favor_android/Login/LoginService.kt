package com.nise.favor_android.Login

import okhttp3.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("/users/sign-up")
    fun requestLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Call<LoginDTO>
}