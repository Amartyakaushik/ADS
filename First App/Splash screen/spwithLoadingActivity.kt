package com.example.sampleapp

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.Layoutsection.cardview_activity

class spwithLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spwith_loading)
        startHeavytask();
    }

    private fun startHeavytask() {
        LongOperation().execute()
    }

    private open inner class LongOperation : AsyncTask<String?,Void ?,String ?>() {
        override fun doInBackground(vararg params: String?): String? {
            for(i in 0..6){
                try {
                    Thread.sleep(1000)
                }
                catch(e:Exception){
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            var intent=Intent(this@spwithLoadingActivity,cardview_activity::class.java)
            startActivity(intent)
        }
    }
}
