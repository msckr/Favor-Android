package com.nise.favor_android.Home.Search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentKeywordBinding

class KeywordFragment : Fragment() {
    private var _binding : FragmentKeywordBinding? = null
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeywordBinding.inflate(layoutInflater)
        return binding.root
    }

}