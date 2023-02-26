package com.nise.favor_android.Home.ui.itemUI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentAllItemBinding
import com.nise.favor_android.databinding.FragmentHomeBinding


class AllItem : Fragment() {
    private var _binding : FragmentAllItemBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllItemBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var adapter = TimelineitemAdapter()
        binding.timelineImage.adapter = adapter
        return root
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}