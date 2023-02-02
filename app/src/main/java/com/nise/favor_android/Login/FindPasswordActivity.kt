package com.nise.favor_android.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityFindPasswordBinding
import java.util.zip.Inflater

class FindPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFindPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}