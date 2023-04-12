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

    @PATCH("users/{userNo}")
    fun repairUser(
        @Body userUpdateRequestDto : userUpdateRequestDto,
        @Path("userNo") userMo : Int
    ): Call<meuser>

    @GET("users/friend-list/{userNo}")
    fun friendList(
        @Path("userNo") userNo: Int
    ): Call<meuser>

    @GET("users/gift-by-category/{userNo}/{category}")
    fun giftByCategory(
        @Path("category") category : String,
        @Path("userNo") userNo: Int
    ): Call<meuser>
}