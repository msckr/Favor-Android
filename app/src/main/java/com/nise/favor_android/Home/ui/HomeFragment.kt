package com.nise.favor_android.Home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nise.favor_android.Home.Add.GiftRegisterActivity
import com.nise.favor_android.Home.Search.SearchActivity
import com.nise.favor_android.Home.ui.itemUI.AllItem
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.searchbtn.setOnClickListener {
            requireActivity().startActivity(Intent(activity, SearchActivity::class.java))
        }
        binding.addGiftbtn.setOnClickListener{
            requireActivity().startActivity(Intent(activity,GiftRegisterActivity::class.java))
        }
        binding.TimeLineTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.TimeLinePage.adapter = TimelineAdapter(this)
        TabLayoutMediator(binding.TimeLineTab, binding.TimeLinePage) {tab, position ->
            when(position) {
                0 -> tab.text = "모든 선물"
                1 -> tab.text = "받은 선물"
                2 -> tab.text = "준 선물"
            }
        }.attach()
        return binding.root


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}