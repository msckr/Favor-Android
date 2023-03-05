package com.nise.favor_android.Home.Add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityGiftRegisterBinding
import java.util.zip.Inflater

class GiftRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGiftRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiftRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}