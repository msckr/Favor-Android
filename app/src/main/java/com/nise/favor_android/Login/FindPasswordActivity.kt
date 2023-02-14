package com.nise.favor_android.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityFindPasswordBinding

class FindPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFindPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editEmail.onFocusChangeListener = onFocusChangeListener
    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()
    private val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        when (v.id) {
            R.id.edit_email -> binding.barEmail
            else -> null
        }!!.setBackgroundResource(if (hasFocus) R.color.textcolor else R.color.box1)
    }
    fun onRequestClick(view: View) {
        when(view.id){
            R.id.btn_login -> startActivity(Intent(this, FindPasswordSecondActivity::class.java))
        }
    }
}