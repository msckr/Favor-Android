package com.nise.favor_android.Home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nise.favor_android.Home.NavActivity
import com.nise.favor_android.Home.Search.SearchActivity
import com.nise.favor_android.MainActivity
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
        return binding.root

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}