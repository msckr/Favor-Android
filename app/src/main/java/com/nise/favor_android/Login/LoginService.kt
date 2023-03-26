package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @POST("users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<meuser>

    @Headers("Content-Type: application/json")
    @PATCH("users/profile")
    fun makeProfile(
        @Body profileMake: ProfileMake,
        @Query("userNo") value : Int
    ): Call<meuser>
}