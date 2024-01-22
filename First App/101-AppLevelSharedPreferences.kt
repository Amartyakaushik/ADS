package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivitySharedPrefereceBinding

class AppLevelSharedPreferece : AppCompatActivity() {
    private lateinit var binding:ActivitySharedPrefereceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySharedPrefereceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.email.setText(editor.getString("Email",null))
        binding.pass.setText(editor.getString("Password",null))

        binding.logInShared.setOnClickListener {
            val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString("Email",binding.email.text.toString())
            editor.putString("Password",binding.pass.text.toString())
            editor.apply()
        }
    }
}
