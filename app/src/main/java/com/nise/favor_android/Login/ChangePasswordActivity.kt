package com.nise.favor_android.Login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()
    fun onRequestClick(view: View) {
        when(view.id){
            R.id.btn_next -> startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}