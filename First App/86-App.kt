package com.example.sampleapp.Class

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.os.Build


class App:Application() {
    final public val CHANNEL_ID1="CHANNEL_ID1"
    final public val CHANNEL_ID2="CHANNEL_ID2"

//    companion object {
//        const val CHANNEL_ID1 = "CHANNEL_ID1"
//        const val CHANNEL_ID2 = "CHANNEL_ID2"
//    }

    override fun onCreate() {
        super.onCreate()

//        to check build sdk version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//            val group1 = NotificationChannelGroup("GROUP_ID1", "Group 1")
//            manager.createNotificationChannelGroup(group1)

//            val channel1=NotificationChannel(CHANNEL_ID1,"Channel 1",NotificationManager.IMPORTANCE_HIGH)
//            channel1.description="This is my high important channel for notification"
//
//            val channel2=NotificationChannel(CHANNEL_ID2,"Channel 2",NotificationManager.IMPORTANCE_DEFAULT)
//            channel2.description="This is my default important channel for notification"

            if (manager.getNotificationChannel(CHANNEL_ID1) == null) {
                val channel1 = NotificationChannel(CHANNEL_ID1, "Channel 1", NotificationManager.IMPORTANCE_HIGH)
//                channel1.group = "GROUP_ID1"
                channel1.description = "This is my High important channel for notification"
                manager.createNotificationChannel(channel1)
            }

            if (manager.getNotificationChannel(CHANNEL_ID2) == null) {
                val channel2 = NotificationChannel(CHANNEL_ID2, "Channel 2", NotificationManager.IMPORTANCE_DEFAULT)
//                channel2.group = "GROUP_ID1"
                channel2.description = "This is my default important channel for notification"
                manager.createNotificationChannel(channel2)
            }

//            manager.createNotificationChannel(channel1)
//            manager.createNotificationChannel(channel2)

        }
    }
}
