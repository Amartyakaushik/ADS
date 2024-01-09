package com.example.sampleapp.Notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.sampleapp.Class.App
import com.example.sampleapp.R
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

////            lecture 88 declaring intent for the notification
//            val intent= Intent(this, NotificationPriority::class.java)
////            Pending Intent is defined for the notification content for further use.
//            val pendingIntent=PendingIntent.getActivity(this@NotificationPriority,0,intent,
//                PendingIntent.FLAG_IMMUTABLE)

//            lecture 89 DATA SHARING WITH ANOTHER ACTIVITY
            val intent= Intent(this, DataShare::class.java)
            intent.putExtra("DATA_REC",binding.content.text.toString())
//            lecture 89 UPDATE_CURRENT
            val pendingIntent=PendingIntent.getActivity(this@NotificationPriority,0,intent,
                PendingIntent.FLAG_UPDATE_CURRENT)

            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)

//                lectrure 88 Customizing the notification
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground,"Back",pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground,"Play",null)
                .addAction(R.drawable.ic_launcher_foreground,"Next",null)
                .setOnlyAlertOnce(true)
//                .setAutoCancel(true)
                .build()

            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }

        binding.lowBtn.setOnClickListener {
            val notification= NotificationCompat.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
//                        lecture 88
//            lecture 88 declaring intent for the notification
//            val intent= Intent(this, NotificationPriority::class.java)
//            Pending Intent is defined for the notification content for further use.
//            val pendingIntent=PendingIntent.getActivity(this@NotificationPriority,0,intent,
//                PendingIntent.FLAG_IMMUTABLE)

//            lecture 89 DATA SHARING WITH ANOTHER ACTIVITY
            val intent= Intent(this, DataShare::class.java)
            intent.putExtra("DATA_REC",binding.content.text.toString())
//            lecture 89 UPDATE_CURRENT
            val pendingIntent=PendingIntent.getActivity(this@NotificationPriority,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)

            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT)

//                lecture 88
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .addAction(R.drawable.ic_launcher_foreground,"Back",pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground,"Play",null)
                .addAction(R.drawable.ic_launcher_foreground,"Next",null)
                .build()

            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())
        }
    }
}
