package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ShareBundle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_bundle)

        // now we declare varibles for each text
        val name=findViewById<EditText>(R.id.name)
        val fathersname=findViewById<EditText>(R.id.fathers_name)
        val roll=findViewById<EditText>(R.id.roll_number)
        val phonenumber=findViewById<EditText>(R.id.phone_number)
        val resultbutton=findViewById<Button>(R.id.resultButton)
        resultbutton.setOnClickListener {
            // here we use the varible name to store the data to transfer
            val name=name.text.toString()
            val fatherName=fathersname.text.toString()
            val rollNumber=roll.text.toString()
            val phoneNumber=phonenumber.text.toString()

            val intent=Intent(this,ResultPage::class.java)
            // here we are providing a new name which can be used in next result page to extract data
            intent.putExtra("name",name)
            intent.putExtra("fatherName",fatherName)
            intent.putExtra("roll",rollNumber)    // here rollNumber is refrenced from line number 24
            intent.putExtra("phone",phoneNumber)
            startActivity(intent)
        }

    }
}
