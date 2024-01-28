package com.example.lpuliveclone.Authentication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lpuliveclone.BottomNavigation.BottomNav_Bar
import com.example.lpuliveclone.R
import com.example.lpuliveclone.databinding.ActivityLogInPageBinding

class LogInPage : AppCompatActivity() {
    private lateinit var binding:ActivityLogInPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.myCheckBox.setOnCheckedChangeListener { it, isChecked ->
            val buttonColor= if(isChecked) R.color.orange else R.color.gray
            binding.LogInBtn.setBackgroundColor(resources.getColor(buttonColor,theme))
        }

        binding.privacyPolicy.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lpu.in/privacy-lpulive.php"))
            startActivity(intent)
        }
        binding.LogInBtn.setOnClickListener {
            if (binding.regId.text != null && binding.password.text != null) {
                if (binding.myCheckBox.isChecked) {
                    val intent = Intent(this, BottomNav_Bar::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please agree to the Privacy and Policy", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please fill both the fields.", Toast.LENGTH_LONG).show()
            }
        }


    }
}