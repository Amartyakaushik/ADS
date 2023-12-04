package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        val SwitchButton=findViewById<Button>(R.id.switchbutton)
        SwitchButton.setOnClickListener {
            val intent= Intent(this,implicitIntent::class.java)
            startActivity(intent)
            finish()
        }

    }
}
