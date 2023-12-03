package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivityFragmentsBinding
import com.example.sampleapp.databinding.ActivityMainBinding
import com.example.sampleapp.fragments.BlankFragment1
import com.example.sampleapp.fragments.BlankFragment2

class FragmentsActivity : AppCompatActivity() {
    // decalration of binding for further process
    override fun onCreate(savedInstanceState: Bundle?) {
    val binding by lazy {
        ActivityFragmentsBinding.inflate(layoutInflater)
    }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Now we need to declare fragment manager and transition tool
        var manager=supportFragmentManager  // Support of fm
        var tr=manager.beginTransaction()  // start of tr
        tr.replace(R.id.frame,BlankFragment1())  // what fr
        tr.commit()

        binding.button01.setOnClickListener {
            var manager=supportFragmentManager  // Support of fm
            var tr=manager.beginTransaction()  // start of tr
            tr.replace(R.id.frame,BlankFragment1())  // what fr
            tr.commit()
        }
        binding.button02.setOnClickListener {
            var manager=supportFragmentManager  // Support of fm
            var tr=manager.beginTransaction()  // start of tr
            tr.replace(R.id.frame,BlankFragment2())  // what fr
            tr.commit()
        }
    }
}