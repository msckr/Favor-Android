package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @POST("/users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<meuser>

    @FormUrlEncoded
    @PATCH("/users/profile")
    fun makeProfile(
        @Body profileMake: ProfileMake,
        @Query("userNo") userNo : Int
    ): Call<meuser>
}