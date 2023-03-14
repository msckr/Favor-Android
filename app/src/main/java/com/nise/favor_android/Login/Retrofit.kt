package com.nise.favor_android.Login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit {
    private const val BaseUrl = "https://favor.inuappcenter.kr/swagger-ui.html#/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : LoginService = retrofit.create(LoginService::class.java)
}

