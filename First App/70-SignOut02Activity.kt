package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivityGoogleAuthenticationBinding
import com.example.sampleapp.databinding.ActivitySignOut02Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SignOut02Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySignOut02Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignOut02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SignOut.setOnClickListener {
            val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
            val go=GoogleSignIn.getClient(this,gso)
            go.signOut()
            startActivity(Intent(this,GoogleAuthenticationActivity::class.java))
        }

    }
}
