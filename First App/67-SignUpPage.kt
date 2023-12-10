package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleapp.databinding.ActivitySignUpPageBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp_page : AppCompatActivity() {
    private val binding:ActivitySignUpPageBinding by lazy {
        ActivitySignUpPageBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // initialization of auth variale to provide access to firebase
        auth=FirebaseAuth.getInstance()

        // To register with all the filled data like (username,email,password)
        binding.registerButton.setOnClickListener {
            val email=binding.email.text.toString()
            val userName=binding.username2.text.toString()
            val passWord=binding.password.text.toString()
            val repeatPassword=binding.repeatpassword.text.toString()

            // now check if any field is left blank
            if(email.isEmpty() || userName.isEmpty() || passWord.isEmpty() || repeatPassword.isEmpty()){
                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()
            }else if(passWord != repeatPassword){
                Toast.makeText(this,"Repeat password must be same as password",Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Registration Successful",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,LogIn_page::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"Registration failed: ${task.exception?.message}",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        // To navigate from signUp page to logIn page through signIn button
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this,LogIn_page::class.java))
            finish()
        }

    }
}
