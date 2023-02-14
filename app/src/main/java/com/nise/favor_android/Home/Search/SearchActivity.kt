package com.nise.favor_android.Home.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.serch.setOnClickListener{
            startActivity(Intent(this,SearchViewActivity::class.java))
        }
    }
}