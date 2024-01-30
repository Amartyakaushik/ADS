package com.example.SharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.Class.User
import com.example.sampleapp.databinding.ActivityAppLevelSharedPrefereceBinding
import com.google.gson.Gson
import android.provider.ContactsContract.Data as Data1

class AppLevelSharedPreferece : AppCompatActivity() {
    private lateinit var binding:ActivityAppLevelSharedPrefereceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAppLevelSharedPrefereceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE)
//        binding.email.setText(editor.getString("Email",null))
//        binding.pass.setText(editor.getString("Password",null))

//        lecture 105
//        Reading non premitive data
        val user=Gson().fromJson(editor.getString("USER_DATA",null),User::class.java)
        binding.email.setText(user.email)
        binding.pass.setText(user.Password)

        binding.logInShared.setOnClickListener {
            val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
//            editor.putString("Email",binding.email.text.toString())
//            editor.putString("Password",binding.pass.text.toString())

//            lecture 105 sharing preferences over non premitive data
//            TO write the non premitive data...
            val user=User(binding.email.text.toString(),binding.pass.text.toString())
            val gson=Gson()
            val Data=gson.toJson(user,User::class.java)
            editor.putString("USER_DATA", Data)

            editor.apply()
            startActivity(Intent(this,FetchData::class.java))
        }
    }
}
