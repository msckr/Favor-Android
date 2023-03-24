package com.nise.favor_android.Register

import Repository
import com.nise.favor_android.Login.ProfileMake

class MakeProfileForm {
    val repo = Repository()
    fun patchMakeProfile(userId:String, name : String){
        var makeProfileForm = ProfileMake(
            userId = userId,
            name = name
        )
        val userNo = 17
        repo.makeProfileForm(makeProfileForm, userNo)
    }
}