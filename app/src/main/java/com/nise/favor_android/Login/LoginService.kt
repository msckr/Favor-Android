package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*
import java.util.SplittableRandom

interface LoginService {

    @FormUrlEncoded
    @POST("/users/sign-up")
    fun requestLogin(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<LoginRequest>

    @FormUrlEncoded
    @PATCH("/users/profile")
    fun changeProfile(
        @Field("userId") userId : String,
        @Field("name") name : String
    ): Call<ChangeProfile>
}