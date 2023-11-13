package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivityWebViewAppBinding
import com.example.sampleapp.databinding.ActivityWebViewBinding

class webViewAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebViewAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.WebViewApp.loadUrl("file:///android_asset/index.html")
    }
}
