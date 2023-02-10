package com.nise.favor_android.Home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nise.favor_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {



    private lateinit var binding: FragmentHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        binding.
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setOnClickListener(){
        val btnSequence = binding.homeFragment
    }

}