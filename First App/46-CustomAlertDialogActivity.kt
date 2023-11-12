package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import cn.pedant.SweetAlert.SweetAlertDialog

class CustomAlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_alert_dialog)

        val btn1=findViewById<Button>(R.id.btn1)
        val btn2=findViewById<Button>(R.id.btn2)
        val btn3=findViewById<Button>(R.id.btn3)
        val btn4=findViewById<Button>(R.id.btn4)


        btn1.setOnClickListener {
            SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Success Sweetalert")
                .setContentText("THis is success Sweetalert Box")
                .show()
        }
        btn2.setOnClickListener {
            SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                .setTitleText("ERROR Sweetalert")
                .setContentText("THis is ERROR Sweetalert Box")
                .show()
        }
        btn3.setOnClickListener {
            SweetAlertDialog(this,SweetAlertDialog.NORMAL_TYPE)
                .setTitleText("NORMAL Sweetalert")
                .setContentText("THis is NORMAL Sweetalert Box")
                .show()
        }
        btn4.setOnClickListener {
            SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE)
                .setTitleText("WARNING Sweetalert")
                .setContentText("THis is WARNING Sweetalert Box")
                .show()
        }

    }
}
