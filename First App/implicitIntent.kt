package com.example.sampleapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.sampleapp.databinding.ActivityImplicitIntentBinding

class implicitIntent : AppCompatActivity() {

    private val binding:ActivityImplicitIntentBinding by lazy{
        ActivityImplicitIntentBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // to open web page
        binding.openWebPage.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/navigation/get-started"))
            startActivity(intent)
        }

        // to open phone dialler
        binding.openPhoneCall.setOnClickListener {
            val intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:+8538946343")
            startActivity(intent)
        }

        // to open Camera
        binding.openCamera.setOnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // to share the filled empty text
        binding.textShareButton.setOnClickListener {
            val text=binding.fillText.text.toString()
            val intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text)
            startActivity(Intent.createChooser(intent,"shareVia"))
        }
    }
}