package com.natusi.hajidanumroh.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natusi.hajidanumroh.R
import com.natusi.hajidanumroh.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.iconBack.setOnClickListener {
            handleBackPressed()
        }
    }

    private fun handleBackPressed() {
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}