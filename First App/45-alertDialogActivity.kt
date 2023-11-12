package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class alertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val btn=findViewById<Button>(R.id.buttonAlert)

        btn.setOnClickListener {
            val dialog=AlertDialog.Builder(this)

            dialog.setTitle("Delete file")
            dialog.setMessage(R.string.Des)
            dialog.setIcon(R.drawable.baseline_delete_forever_24)


            dialog.setPositiveButton("Yes"){dialogInterface,which->
                Toast.makeText(this,"Clicked YEs",Toast.LENGTH_LONG).show()
            }
            dialog.setNegativeButton("No"){dialogInterface,which->
                Toast.makeText(this,"Clicked No",Toast.LENGTH_LONG).show()
            }
            dialog.setNeutralButton("Cancel"){dialogInterface,which->
                Toast.makeText(this,"Clicked Cancel",Toast.LENGTH_LONG).show()
            }

            val alertDialog:AlertDialog=dialog.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}
