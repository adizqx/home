package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.home.databinding.FragmentS2Binding


class S2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentS2Binding.inflate(inflater)
//        val text = arguments?.getString( "text")
//        binding.textView.text = text
        return binding.root
//    }
    }


    }
