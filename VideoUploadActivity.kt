package com.example.sampleapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.sampleapp.databinding.ActivityVideoUploadBinding

class VideoUploadActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVideoUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVideoUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.videoView.isVisible=false
        binding.videoBtn.setOnClickListener{
            val intent=Intent()
            intent.action=Intent.ACTION_PICK
            intent.type="video/*"
            videoLauncher.launch(intent)
        }
    }

    // Defining a global variable to lauch the video upload activity

    val videoLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode== Activity.RESULT_OK){
            if (it.data!=null){
                binding.videoBtn.isVisible=false
                binding.videoView.isVisible=true
                val mediaController=MediaController(this)
                mediaController.setAnchorView(binding.videoView)
                binding.videoView.setVideoURI(it.data!!.data)
                binding.videoView.setMediaController(mediaController)
                binding.videoView.start()
            }
        }
    }
}