package com.nise.favor_android.Login

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("responseCode")
    val responseCode: String,
    @SerializedName("responseMessage")
    val responseMessage: String,
    @SerializedName("data")
    val data: List<Data>
)

data class Data(
    @SerializedName("userNo")
    val userNo: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: Any,
    @SerializedName("userId")
    val userid: Any,
    @SerializedName("role")
    val role: String,
    @SerializedName("reminderList")
    val reminderList: List<Any>,
    @SerializedName("favorList")
    val favorList: List<Any>,
    @SerializedName("friendList")
    val friendList: List<Any>,
    @SerializedName("giftlist")
    val giftlist: List<Any>,
)