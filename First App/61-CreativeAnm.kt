package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.sampleapp.databinding.ActivityCreativeAnmBinding
import com.github.ybq.android.spinkit.style.DoubleBounce
import render.animations.Bounce
import render.animations.Render
//import com.github.ybq.android.spinkit.SpinKitView


class creativeAnm : AppCompatActivity() {
    private lateinit var binding: ActivityCreativeAnmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCreativeAnmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // declaration of Double Bounce
        val doubleBounce= DoubleBounce()
        binding.spinKit.setIndeterminateDrawable(doubleBounce)

        binding.spinKit.setOnClickListener {
            val render = Render(this)
        // Set Animation
            render.setAnimation(Bounce().InDown(binding.spinKit))
            render.start()
        }


        }
    }

