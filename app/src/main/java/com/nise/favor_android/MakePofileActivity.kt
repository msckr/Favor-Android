package com.nise.favor_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.nise.favor_android.databinding.ActivityMakePofileBinding

class MakePofileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakePofileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakePofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editName.onFocusChangeListener = onFocusChangeListener
        binding.editId.onFocusChangeListener = onFocusChangeListener

        binding.editName.doAfterTextChanged { btnActivation() }
        binding.editId.doAfterTextChanged {
            btnActivation()
            if (it!!.isBlank()) return@doAfterTextChanged
            if (it.toString() == "@") it.clear()
            else if (!it.startsWith("@")) it.insert(0, "@")
        }
    }

    private val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        when (v.id) {
            R.id.edit_name -> binding.barName
            R.id.edit_id -> binding.barId
            else -> null
        }!!.setBackgroundResource(if (hasFocus) R.color.textcolor else R.color.box1)
    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()

    fun onNextButtonClicked(view: View) {
        if (verify()) startActivity(Intent(applicationContext, RegisterTermActivity::class.java))
    }

    private fun verify(): Boolean =
        binding.editName.text.isNotBlank() && binding.editId.text.isNotBlank() && binding.editId.length() > 1

    private fun btnActivation() {
        if (verify()) {
            binding.btnNext.setTextColor(getColor(R.color.white))
            binding.btnNext.setBackgroundResource(R.drawable.back_button_dark)
        } else {
            binding.btnNext.setTextColor(getColor(R.color.textcolor))
            binding.btnNext.setBackgroundResource(R.drawable.back_button_light)
        }
    }
}