package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivityLogInSignOutPageBinding
import com.google.firebase.auth.FirebaseAuth

class LogIn_SignOut_Page : AppCompatActivity() {
    private val binding: ActivityLogInSignOutPageBinding by lazy {
        ActivityLogInSignOutPageBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Initializing
        auth=FirebaseAuth.getInstance()

//        private fun signOut(){
//            auth.getInstance()
//                .signOut(this)
//                .addOnCompleteListener {task ->
//                    // Handle the sign-out completion if needed
//                    if (task.isSuccessful) {
//                        // After signing out, navigate to the login page or any other desired destination
//                        val intent = Intent(this, LogIn_page::class.java)
//                        startActivity(intent)
//
//                        // Finish the current activity to prevent the user from coming back to the logged-in page using the back button
//                        finish()
//                    } else {
//                        // Handle sign-out failure if needed
//                    }
//                }
//        }


        fun signOut() {
            auth.signOut()

            // After signing out, navigate to the login page or any other desired destination
            val intent = Intent(this, LogIn_page::class.java)
            startActivity(intent)

            // Finish the current activity to prevent the user from coming back to the logged-in page using the back button
            finish()
        }
        binding.logOutButton.setOnClickListener {
            signOut()
        }

        // lecture -71 Firebase Realtime database
        // now to create  notes in the form of data
        binding.CreateNotesButton.setOnClickListener {
            startActivity(Intent(this,AddNotesActivity::class.java))
            finish()
        }

        // to save data entered in the add notes page
        binding.OpenNotesButton.setOnClickListener {

        }
    }

}
