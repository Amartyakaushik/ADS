package com.example.sampleapp.Notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivityFcmnotificationBinding

class FCMnotification : AppCompatActivity() {
    private lateinit var binding:ActivityFcmnotificationBinding
    var dataString:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFcmnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent != null){
            if(intent.hasExtra("Key")){
                for( key in intent.extras!!.keySet()) {
                    dataString=dataString+intent.extras!!.getString(key)+"\n"
                }
                binding.txtView.text= this.dataString
            }
        }
    }
}
