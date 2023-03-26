package com.nise.favor_android.Register

import Repository
import com.nise.favor_android.Login.ProfileMake

class MakeProfileForm {
    val repo = Repository()
    fun patchMakeProfile(userId:String, name : String,userNo : Int){
        var makeProfileForm = ProfileMake(
            userId = userId,
            name = name
        )
    }
}