package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sampleapp.fragments.BlankFragment_LC_1
//import

class Fragment_lifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_life_cycle)

        // now we declare openFragment variable for using button
        val openFragment=findViewById<Button>(R.id.button9)
        val fragment=BlankFragment_LC_1()
        val transient=supportFragmentManager.beginTransaction()
        transient.replace(R.id.frameLayout,fragment)
        transient.addToBackStack(null)
        transient.commit()
    }
}