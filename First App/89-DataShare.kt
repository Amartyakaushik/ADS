package com.example.sampleapp.Notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivityDataShareBinding

class DataShare : AppCompatActivity() {
    private lateinit var binding:ActivityDataShareBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDataShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txt.setText(intent.getStringExtra("DATA_REC"))
    }
}
