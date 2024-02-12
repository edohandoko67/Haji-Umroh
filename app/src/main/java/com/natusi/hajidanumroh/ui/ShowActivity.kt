package com.natusi.hajidanumroh.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natusi.hajidanumroh.auth.ApiClient.URL_IMAGE
import com.natusi.hajidanumroh.databinding.ActivityShowBinding
import com.squareup.picasso.Picasso

class ShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.iconBack.setOnClickListener {
            handleBackPressed()
        }

        binding.infoSelengkapnya.setOnClickListener {
            sendToWA()
        }
        val i = intent
        val imgUrl = URL_IMAGE + i.getStringExtra("image")
        Picasso.get().load(imgUrl).into(binding.imgShow)

    }

    private fun sendToWA() {
        val whatappUser = "+62895342642087"
        val url = "https://api.whatsapp.com/send?phone=$whatappUser"
        try {
            val packageManager = applicationContext.packageManager
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } catch (e: PackageManager.NameNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    private fun handleBackPressed() {
        onBackPressed()
    }

}