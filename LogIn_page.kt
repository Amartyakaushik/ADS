package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleapp.databinding.ActivityLogInPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LogIn_page : AppCompatActivity() {
    private val binding:ActivityLogInPageBinding by lazy {
        ActivityLogInPageBinding.inflate(layoutInflater)
    }

    // declaring variable to activate login button
    private lateinit var auth: FirebaseAuth

    // If user is already logged in then redirect directly to dashboard (login and signup page)
    override fun onStart() {
        super.onStart()
        // now check if the user if logged in or not
        val currentUser:FirebaseUser?=auth.currentUser
        if(currentUser!=null){
            startActivity(Intent(this,LogIn_SignOut_Page::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initializing
        auth=FirebaseAuth.getInstance()

        binding.logInButton.setOnClickListener {
            val userName=binding.username.text.toString()
            val passWord=binding.password.text.toString()

            // To check if all the details are filled or not
            if(userName.isEmpty() || passWord.isEmpty()){
                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(userName,passWord).addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Sign in successful",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,LogIn_SignOut_Page::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"LogIn failed: ${task.exception?.message}",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this,SignUp_page::class.java))
            finish()
        }
    }
}