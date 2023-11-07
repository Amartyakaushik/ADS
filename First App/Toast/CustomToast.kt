package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.emreesen.sntoast.SnToast.Custom
import com.shashank.sony.fancytoastlib.FancyToast


class CustomToast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)
        val defaultButton=findViewById<Button>(R.id.buttonDefault)
        val fancyButton=findViewById<Button>(R.id.buttonFancy)

        defaultButton.setOnClickListener {
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show();
        }

        fancyButton.setOnClickListener {
            Custom()
                .context(this@CustomToast)
                .backgroundColor(R.color.white)
                .textColor(R.color.lightYellow)
                .icon(R.drawable.baseline_auto_awesome_24)
                .message("Hola ❤️ !!!") // .iconSize(int size) Optional Default: 34dp
                 .textSize(24)       //Optional Default 18sp
                 .animation(true)       //Optional Default: True
                 .cancelable(false)       //Optional Default: False
                 .duration(4000)      // Optional Default: 3000ms
                .build()
        }


    }
}