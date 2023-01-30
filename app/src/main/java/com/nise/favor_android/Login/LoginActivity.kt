package com.nise.favor_android.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityLoginBinding

@Suppress("UNUSED_PARAMETER")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editEmail.onFocusChangeListener = onFocusChangeListener
        binding.editPassword.onFocusChangeListener = onFocusChangeListener
    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()
    fun onLoginClicked(view: View) {}
    fun onFindEmailClicked(view: View) {}
    fun onFindPasswordClicked(view: View) {}

    private val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        when (v.id) {
            R.id.edit_email -> binding.barEmail
            R.id.edit_password -> binding.barPassword
            else -> null
        }!!.setBackgroundResource(if (hasFocus) R.color.textcolor else R.color.box1)
    }
}