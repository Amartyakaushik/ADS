package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import com.example.sampleapp.R.id.slide_down

class AnimationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)

        // variable for every separate animtions
        val animText=findViewById<TextView>(R.id.box01)
        val fadeIn=findViewById<Button>(R.id.fade_in)
        val fadeOut=findViewById<Button>(R.id.fade_out)
        val zoomIn=findViewById<Button>(R.id.zoom_in)
        val zoomOut=findViewById<Button>(R.id.zoom_out)
        val slideUp=findViewById<Button>(R.id.slide_up)
        val slideDown=findViewById<Button>(R.id.slide_down)
        val rotate=findViewById<Button>(R.id.rotate)
        val bounce=findViewById<Button>(R.id.bounce)

        fadeIn.setOnClickListener {
            val animationFadeIn=AnimationUtils.loadAnimation(this,R.anim.fade_in)
            animText.startAnimation(animationFadeIn)
        }

        fadeOut.setOnClickListener {
            val animationFadeOut=AnimationUtils.loadAnimation(this,R.anim.fade_out)
            animText.startAnimation(animationFadeOut)
        }
        zoomIn.setOnClickListener {
            val animationZoomIn=AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            animText.startAnimation(animationZoomIn)
        }
        zoomOut.setOnClickListener {
            val animationZoomOut=AnimationUtils.loadAnimation(this,R.anim.zoom_out)
            animText.startAnimation(animationZoomOut)
        }
        slideUp.setOnClickListener {
            val animationSlideUp=AnimationUtils.loadAnimation(this,R.anim.slide_up)
            animText.startAnimation(animationSlideUp)
        }
        slideDown.setOnClickListener {
            val animationSlideDown=AnimationUtils.loadAnimation(this,R.anim.slide_down)
            animText.startAnimation(animationSlideDown)
        }
        rotate.setOnClickListener {
            val animationRotate=AnimationUtils.loadAnimation(this,R.anim.rotate)
            animText.startAnimation(animationRotate)
        }
        bounce.setOnClickListener {
            val animationBounce=AnimationUtils.loadAnimation(this,R.anim.bounce)
            animText.startAnimation(animationBounce)
        }


    }
}
