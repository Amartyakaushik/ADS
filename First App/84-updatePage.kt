package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.databinding.ActivityUpdatePageBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class updatePage : AppCompatActivity() {
    private lateinit var binding:ActivityUpdatePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdatePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= Firebase.firestore
        binding.updatedUsername.setText(intent.getStringExtra("NAME"))
        binding.updatedPassword.setText(intent.getStringExtra("Pass"))
        binding.updatedBtn.setOnClickListener{
            val user= hashMapOf(
                "name" to binding.updatedUsername.text.toString(),
                "pass" to binding.updatedPassword.text.toString()
            )

            db.collection("Users")
                .document(intent.getStringExtra("ID")!!).set(user)
            finish()
        }
    }
}
