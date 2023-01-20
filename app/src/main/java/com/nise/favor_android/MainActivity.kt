package com.nise.favor_android


import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nise.favor_android.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener(){
            Log.d(TAG,"회원가입")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        register_btn.setOnClickListener(){
            Log.d(TAG,"회원가입")
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}