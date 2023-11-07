package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        val toastButton=findViewById<Button>(R.id.buttonToast)

        toastButton.setOnClickListener { Toast.makeText(this,"Hi i am Toast",Toast.LENGTH_LONG).show()
        }
    }
}