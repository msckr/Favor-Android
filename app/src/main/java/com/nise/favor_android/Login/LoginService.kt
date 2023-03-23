package com.nise.favor_android.Login

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @POST("/swagger-ui.html#/users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<UserDTO>


    @PATCH("/swagger-ui.html#/users/profile")
    fun makeProfile(
        @Body profileMake: ProfileMake,
        @Query("userNo") userNo : Int
    ): Call<UserDTO>
}