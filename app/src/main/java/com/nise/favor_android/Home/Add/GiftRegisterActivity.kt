@file:OptIn(ExperimentalFoundationApi::class)

package com.nise.favor_android.Home.Add

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nise.favor_android.Home.Add.ui.GivePrFragment
import com.nise.favor_android.Home.Add.ui.RecievePrFragment
import com.nise.favor_android.Home.Add.ui.RegisterAdapter
import com.nise.favor_android.databinding.ActivityGiftRegisterBinding


class GiftRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGiftRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiftRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
        binding.register.isUserInputEnabled=false
    }
    private fun initViewPager() {
        var viewPager2Adatper = RegisterAdapter(this)
        viewPager2Adatper.addFragment(RecievePrFragment())
        viewPager2Adatper.addFragment(GivePrFragment())

        binding.register.apply {
            adapter = viewPager2Adatper
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                    super.onPageSelected(position)
                }
            })
        }

        TabLayoutMediator(binding.registerTab, binding.register) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "준 선물"
                1 -> tab.text = "받은 선물"
            }
        }.attach()
    }
    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()
}
