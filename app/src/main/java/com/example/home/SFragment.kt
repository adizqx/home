package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.home.databinding.FragmentSBinding


class SFragment : Fragment() {
    lateinit var binding: FragmentSBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSBinding.inflate(inflater)


//        val test = binding.tvH.text.toString()
//        val test2 = "$test ${Random.nextInt(100 )}"
//        binding.tvH.text = test2

//          binding.btnRandom.setOnClickListener{
//              getRandomImage()
//          }

//
//        binding.btnX.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("text", "HELLOLO")
//            val fragment = S2Fragment()
//            fragment.arguments = bundle
//
//            activity
//                ?.supportFragmentManager
//                ?.beginTransaction()
//                ?.addToBackStack("SecondFragment")
//                ?.replace(R.id.place_holder, fragment)
//                ?.commit()
//        }
        return binding.root
    }

//fun getRandomImage(){
//    Glide.with(this)
//        .load("http://source.unsplash.com/random/800x600")
//        .skipMemoryCache(true)
//        .diskCacheStrategy(DiskCacheStrategy.NONE)
//        .into(binding.imageView)

    }




