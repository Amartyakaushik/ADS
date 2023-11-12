package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import com.example.sampleapp.databinding.ActivityMainBinding
import com.example.sampleapp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private val binding:ActivityWebViewBinding by lazy {
        ActivityWebViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // to display any website on your UI
        binding.webView.loadUrl("https://www.geeksforgeeks.org/")
        // to enable every feature we need to provide access to JavaScript file
        binding.webView.settings.javaScriptEnabled=true
        //to restrict the chrome page navigation
        binding.webView.webViewClient= WebViewClient()
        // to control navigation of web page history

    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }
}