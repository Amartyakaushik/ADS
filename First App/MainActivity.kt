package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "onCreate: I am running")
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()
    }
    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart: I am running")
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: I am running")
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: I am running")
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: I am running")
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart: I am running")
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: I am running")
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }
}