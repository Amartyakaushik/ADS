package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.Layoutsection.cardview_activity

class SpwithAnimationGIFActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spwith_animation_gifactivity)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this@SpwithAnimationGIFActivity,cardview_activity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}