package com.example.sampleapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.sampleapp.databinding.ActivityHomePageBinding
import kotlinx.coroutines.delay

class HomePage : AppCompatActivity() {
    private val binding:ActivityHomePageBinding by lazy{
        ActivityHomePageBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // To navigate from home page to login page
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LogIn_page::class.java))
        },3000)

        // declare variables
        val welcomeText="Welcome"
        val spannableString= SpannableString(welcomeText)

        // To change the color of the string
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF0000")),0,5,0)
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#312222")),5,welcomeText.length,0)
        binding.welcomeText.text=spannableString



    }
}

