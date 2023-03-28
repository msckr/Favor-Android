package com.nise.favor_android.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import com.nise.favor_android.Home.NavActivity
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityRegisterTermBinding

class RegisterTermActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterTermBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTermBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra("name")
        binding.profileName.setText(data)
        binding.checkTerm1.setOnCheckedChangeListener(onCheckedChangedListener)
        binding.checkTerm2.setOnCheckedChangeListener(onCheckedChangedListener)
        binding.checkTerm3.setOnCheckedChangeListener(onCheckedChangedListener)
        binding.checkTerms.setOnClickListener {
            val isChecked = binding.checkTerms.isChecked
            binding.checkTerm1.isChecked = isChecked
            binding.checkTerm2.isChecked = isChecked
            binding.checkTerm3.isChecked = isChecked
        }
    }


    private val onCheckedChangedListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        if (!isChecked) binding.checkTerms.isChecked = false
        if (verify() && binding.checkTerm3.isChecked) binding.checkTerms.isChecked = true
        btnActivation()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onNextButtonClicked(view: View) {
        val intent = Intent(applicationContext, NavActivity::class.java)
        startActivity(intent)
    }

    fun onViewTermClicked(view: View) {
        when (view.tag) {
            "1" -> {}
            "3" -> {}
        }
    }

    private fun verify(): Boolean = binding.checkTerm1.isChecked && binding.checkTerm2.isChecked

    private fun btnActivation() {
        if (verify()) {
            binding.btnNext.setTextColor(getColor(R.color.white))
            binding.btnNext.setBackgroundResource(R.drawable.back_maincolor)
        } else {
            binding.btnNext.setTextColor(getColor(R.color.textcolor))
            binding.btnNext.setBackgroundResource(R.drawable.back_button_light)
        }
    }
}