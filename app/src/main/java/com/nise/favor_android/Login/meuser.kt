package com.nise.favor_android.Login


import com.google.gson.annotations.SerializedName

data class meuser(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("responseCode")
    val responseCode: String,
    @SerializedName("responseMessage")
    val responseMessage: String
) {
    data class Data(
        @SerializedName("email")
        val email: String,
        @SerializedName("favorList")
        val favorList: List<Any>,
        @SerializedName("friendList")
        val friendList: List<Any>,
        @SerializedName("giftlist")
        val giftlist: List<Any>,
        @SerializedName("name")
        val name: Any,
        @SerializedName("reminderList")
        val reminderList: List<Any>,
        @SerializedName("role")
        val role: String,
        @SerializedName("userNo")
        val userNo: Int,
        @SerializedName("userid")
        val userid: Any
    )
}