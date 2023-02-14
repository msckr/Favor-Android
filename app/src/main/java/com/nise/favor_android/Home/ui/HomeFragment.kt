package com.nise.favor_android.Home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.nise.favor_android.Home.Search.SearchActivity
import com.nise.favor_android.Login.LoginActivity
import com.nise.favor_android.R
import com.nise.favor_android.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers.Main

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
        binding.searchbtn.setOnClickListener{
            activity?.let{
                val intent = Intent(context,SearchActivity::class.java)
                startActivity(intent)
            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setOnClickListener(){
        val btnSequence = binding.homeFragment
    }

}