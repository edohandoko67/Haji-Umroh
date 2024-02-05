package com.natusi.hajidanumroh.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.natusi.hajidanumroh.R
import com.natusi.hajidanumroh.databinding.ActivityWebBinding


class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        binding = ActivityWebBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("http://192.168.2.111/develop/KBIHU_Al-Rahmah/public/")
        val webSettings: WebSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true
    }
}