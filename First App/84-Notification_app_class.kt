package com.example.sampleapp.Class

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class App:Application() {
    final private val CHANNEL_ID1="CHANNEL_ID1"
    final private val CHANNEL_ID2="CHANNEL_ID2"

    override fun onCreate() {
        super.onCreate()

//        to check build sdk version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1=NotificationChannel(CHANNEL_ID1,"Channel 1",NotificationManager.IMPORTANCE_HIGH)
            channel1.description="This is my high important channel for notification"

            val channel2=NotificationChannel(CHANNEL_ID2,"Channel 2",NotificationManager.IMPORTANCE_DEFAULT)
            channel2.description="This is my default important channel for notification"

            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)

        }
    }
}
