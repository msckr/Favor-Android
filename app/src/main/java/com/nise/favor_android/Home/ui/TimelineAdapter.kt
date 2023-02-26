package com.nise.favor_android.Home.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nise.favor_android.Home.ui.itemUI.AllItem
import com.nise.favor_android.Home.ui.itemUI.GiveItem
import com.nise.favor_android.Home.ui.itemUI.ReciveItem
import com.nise.favor_android.onBoard.ViewPagerAdapter

class TimelineAdapter(fragment: HomeFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllItem()
            1 -> ReciveItem()
            else -> GiveItem()
        }
    }
}