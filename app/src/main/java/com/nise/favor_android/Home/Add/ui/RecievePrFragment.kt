package com.nise.favor_android.Home.Add.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentGivePrBinding
import com.nise.favor_android.databinding.FragmentRecievePrBinding


class RecievePrFragment : Fragment() {
    private var _binding : FragmentRecievePrBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecievePrBinding.inflate(inflater, container, false)
        return binding.root
    }

}