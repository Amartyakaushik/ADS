package com.example.SharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.Class.User
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivityFetchDataBinding
import com.google.gson.Gson

class FetchData : AppCompatActivity() {
    private lateinit var binding: ActivityFetchDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFetchDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        val user=Gson().fromJson(editor.getString("USER_DATA",null),User::class.java)

//        binding.fetchData.setText("Hey your Email is ${editor.getString("Email",null)}"+" And your password is ${editor.getString("Password",null)}")
//    lecture 105 fetching non premitive data

        binding.fetchData.setText("Hey your Email is ${user.email}" + " And your password is ${user.Password}")
    }
}
