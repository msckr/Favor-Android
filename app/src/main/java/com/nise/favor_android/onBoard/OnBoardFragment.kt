package com.nise.favor_android.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nise.favor_android.databinding.FragmentOnBoardBinding
import com.nise.favor_android.onBoard.onBoarding.FirstFragment
import com.nise.favor_android.onBoard.onBoarding.SecondFragment
import com.nise.favor_android.onBoard.onBoarding.ThirdFragment


class onBoardFragment : Fragment() {
    private var _binding: FragmentOnBoardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //1
        setupViewPager()
    }

    private fun setupViewPager() {
        val fragmentList = arrayListOf(
            FirstFragment.newInstance(),
            SecondFragment.newInstance(),
            ThirdFragment.newInstance()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        binding.viewPager.isUserInputEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}