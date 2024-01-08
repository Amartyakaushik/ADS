package com.example.sampleapp

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.sampleapp.Class.App
import com.example.sampleapp.databinding.ActivityNotificationPriorityBinding

class NotificationPriority : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationPriorityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNotificationPriorityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.highBtn.setOnClickListener{
            val notification= NotificationCompat.Builder(this,App().CHANNEL_ID1)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }

        binding.lowBtn.setOnClickListener {
            val notification= NotificationCompat.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())
        }
    }
}
