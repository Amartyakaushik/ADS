package com.example.Service

import android.app.IntentService
import android.content.Intent
import android.content.Context

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        if(intent!=null){
            android.util.Log.d("MYTAG", intent.getStringExtra("DATA_REC")!!)
        }
    }

    companion object {
    }
}
