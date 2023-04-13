package com.nise.favor_android.Home.ui.itemUI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentAllItemBinding


class AllItem : Fragment() {
    private var _binding : FragmentAllItemBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllItemBinding.inflate(inflater, container, false)

        val adapter = TimelineitemAdapter()

        adapter.images = arrayListOf(
            R.drawable.favor_icon,
            R.drawable.favor_icon,
            R.drawable.favor_icon,
            R.drawable.favor_icon
        )

        val manager = GridLayoutManager(requireContext(), 2)

        binding.timelineImage.layoutManager = manager

        binding.timelineImage.adapter = adapter


        val root: View = binding.root



        return root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}