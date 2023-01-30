package com.nise.favor_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nise.favor_android.Login.LoginActivity
import com.nise.favor_android.Register.RegisterActivity

class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> startActivity(Intent(this, LoginActivity::class.java))
            R.id.btn_register -> startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}