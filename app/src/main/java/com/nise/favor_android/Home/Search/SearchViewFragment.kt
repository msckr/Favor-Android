package com.nise.favor_android.Home.Search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentHomeBinding
import com.nise.favor_android.databinding.FragmentSearchViewBinding

class SearchViewFragment : Fragment() {
    private var _binding: FragmentSearchViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}