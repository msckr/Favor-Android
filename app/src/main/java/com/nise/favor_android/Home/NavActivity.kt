package com.nise.favor_android.Home

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.nise.favor_android.Home.Search.SearchActivity
import com.nise.favor_android.Home.ui.HomeFragment
import com.nise.favor_android.Home.ui.MypageFragment
import com.nise.favor_android.Home.ui.ReminderFragment
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityNavBinding


class NavActivity : AppCompatActivity() {


    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.reminder -> replaceFragment(ReminderFragment())
                R.id.mypage -> replaceFragment(MypageFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransacion = fragmentManager.beginTransaction()
        fragmentTransacion.replace(R.id.fragment_frame,fragment)
        fragmentTransacion.commit()
    }
}