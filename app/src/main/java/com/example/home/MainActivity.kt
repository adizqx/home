package com.example.home

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.home.databinding.ActivityMainBinding
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var useKeyword: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRandom.setOnClickListener {
            getRandomImage()
        }
        binding.btnRandom.setOnLongClickListener{
            showToastWithRandomNumber()
        }
        binding.btnRandom2.setOnClickListener {
             onGetRandomImagePressed()
        }
        binding.ed1.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                return@setOnEditorActionListener onGetRandomImagePressed()
            }
            return@setOnEditorActionListener false
        }
       binding.cbox.setOnClickListener{
           this.useKeyword = binding.cbox.isChecked
         updateUI()
       }
//        binding.cbox.setOnCheckedChangeListener { _, isChecked ->
//            updateUI()
//        }
//        binding.b1.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction().replace(R.id.place_holder, SFragment()).commit()
//        }

    }
    fun updateUI() = with(binding){
        cbox.isChecked = useKeyword
        if(useKeyword){ed1.visibility = View.VISIBLE} else {ed1.visibility = View.GONE}
    }

    fun onGetRandomImagePressed():Boolean {
        val keyword = binding.ed1.text.toString()
        if (useKeyword && keyword.isBlank()) {
            binding.ed1.error = "Wrong"
            return true
        }

        val encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())
        Glide.with(this)
            .load("https://source.unsplash.com/random/800x600${if (useKeyword)"?$encodedKeyword" else ""}")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(binding.imageView)

        return false
    }

    fun getRandomImage() {
        Glide.with(this)
            .load("https://source.unsplash.com/random/800x600")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(binding.imageView)
    }
    fun showToastWithRandomNumber():Boolean{
        val number = Random.nextInt(100)
        val messege = getString(R.string.random_number, number)
        Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
        return true
    }
}