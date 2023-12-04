package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        //here we are decalring variale for each TextView
        val name=findViewById<TextView>(R.id.showName)
        val fathername=findViewById<TextView>(R.id.showFathersName)
        val rollnumber=findViewById<TextView>(R.id.showRoll)
        val phonenumber=findViewById<TextView>(R.id.showPhoneNumber)

        val intent=intent
        val names=intent.getStringExtra("name")
        val fathersName=intent.getStringExtra("fatherName")
        val rollNumber=intent.getStringExtra("roll")
        val phoneNumber=intent.getStringExtra("phoneNumber")

    //  (val 19)          (val 13)
        name.text="Name :$names"
        fathername.text="Fathers Name: $fathersName"
        rollnumber.text="Roll number: $rollNumber"
        phonenumber.text="Phone num: $phoneNumber"
    }
}
